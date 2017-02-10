package com.programmingwizzard.mccord.discord.tasks;

import com.programmingwizzard.mccord.discord.DiscordBot;
import com.programmingwizzard.mccord.discord.basic.DMessage;
import com.programmingwizzard.mccord.discord.basic.bot.Task;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

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

    }

    public void addElement(DMessage message) {
        if (message == null) {
            return;
        }
        dMessageQueue.add(message);
    }
}
