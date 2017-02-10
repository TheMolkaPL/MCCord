package com.programmingwizzard.mccord.discord.basic.bot;

import com.programmingwizzard.mccord.discord.DiscordBot;
import org.bukkit.Bukkit;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public interface Task extends Runnable {

    void execute();

    @Override
    default void run() {
        this.execute();
    }

    default void start(DiscordBot bot, long period) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(bot.getMCCord(), this, period, period);
    }
}
