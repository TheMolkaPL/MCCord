package com.programmingwizzard.mccord.discord.basic;

import com.programmingwizzard.mccord.discord.Configuration;
import com.programmingwizzard.mccord.discord.DiscordBot;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public abstract class Module {

    private final Configuration configuration;
    private final DiscordBot bot;

    public Module(Configuration configuration, DiscordBot bot) {
        this.configuration = configuration;
        this.bot = bot;
    }

    public abstract void onEnable();

    protected final Configuration getConfiguration() {
        return configuration;
    }

    protected final DiscordBot getBot() {
        return bot;
    }

}
