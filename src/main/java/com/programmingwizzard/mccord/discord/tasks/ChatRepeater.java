package com.programmingwizzard.mccord.discord.tasks;

import com.programmingwizzard.mccord.discord.DiscordBot;
import com.programmingwizzard.mccord.discord.basic.DMessage;
import com.programmingwizzard.mccord.discord.basic.bot.Task;
import net.dv8tion.jda.core.entities.TextChannel;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Level;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public class ChatRepeater implements Task {

    private final Queue<DMessage> dMessageQueue = new SynchronousQueue<>();
    private final DiscordBot bot;

    public ChatRepeater(DiscordBot bot) {
        this.bot = bot;
    }

    @Override
    public void execute() {
        DMessage dMessage = dMessageQueue.poll();
        if (dMessage == null) {
            return;
        }
        switch (dMessage.getType()) {
            case DISCORD:
                String channelId = bot.getConfiguration().get("bot.modules.chat-module.channel-id");
                if (channelId == null) {
                    bot.getMCCord().getLogger().log(Level.SEVERE, "ChannelId can not be null!");
                    return;
                }
                TextChannel channel = bot.getJDA().getTextChannelById(channelId);
                if (channel == null) {
                    bot.getMCCord().getLogger().log(Level.SEVERE, "TextChannel with this id does not exists!");
                    return;
                }
                String message = bot.getConfiguration().get("bot.modules.chat-module.discord");
                if (message == null) {
                    bot.getMCCord().getLogger().log(Level.SEVERE, "Message can not be null!");
                    return;
                }
                message = message.replaceAll("%nickname", dMessage.getNickname()).replaceAll("%message", dMessage.getMessage());
                channel.sendMessage(message).queue();
                break;
            case MINECRAFT:
                break;
            default:
                bot.getMCCord().getLogger().log(Level.WARNING, "Valid DMessageType! Author: " + dMessage.getNickname() + ", Message: " + dMessage.getMessage());
                break;
        }
    }

    public void addElement(DMessage message) {
        if (message == null) {
            return;
        }
        dMessageQueue.add(message);
    }
}
