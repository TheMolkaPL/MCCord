package com.programmingwizzard.mccord.discord.modules;

import com.programmingwizzard.mccord.discord.DiscordBot;
import com.programmingwizzard.mccord.discord.basic.bot.Module;
import com.programmingwizzard.mccord.discord.listeners.TextMessageListener;
import com.programmingwizzard.mccord.discord.tasks.ChatRepeater;
import com.programmingwizzard.mccord.minecraft.AsyncPlayerChatListener;
import org.bukkit.Bukkit;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public class ChatModule extends Module {

    private final ChatRepeater repeater;

    public ChatModule(DiscordBot bot) {
        super(bot);
        this.repeater = new ChatRepeater(bot);
    }

    @Override
    public void onEnable() {
        boolean bool = getBot().getConfiguration().get("bot.modules.chat-module.enabled");
        if (!bool) {
            return;
        }
        getBot().getJDA().addEventListener(new TextMessageListener(repeater));
        Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(repeater), getBot().getMCCord());
        this.repeater.start(getBot(), 1000);
    }
}
