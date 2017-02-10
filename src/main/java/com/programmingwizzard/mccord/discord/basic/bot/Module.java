package com.programmingwizzard.mccord.discord.basic.bot;

import com.programmingwizzard.mccord.discord.DiscordBot;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public abstract class Module {

    private final DiscordBot bot;

    public Module(DiscordBot bot) {
        this.bot = bot;
    }

    public abstract void onEnable();

    protected final DiscordBot getBot() {
        return bot;
    }

}
