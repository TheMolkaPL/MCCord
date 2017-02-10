package com.programmingwizzard.mccord;

import com.programmingwizzard.mccord.discord.Configuration;
import com.programmingwizzard.mccord.discord.DiscordBot;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.util.logging.Level;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public class MCCord extends JavaPlugin {

    private Configuration configuration;
    private DiscordBot discordBot;

    @Override
    public void onLoad() {
        this.saveDefaultConfig();
        this.configuration = new Configuration(this.getConfig());
        this.discordBot = new DiscordBot(this);
    }

    @Override
    public void onEnable() {
        boolean bool = configuration.get("enabled");
        if (!bool) {
            this.getLogger().log(Level.WARNING, "This plugin is not activated in the configuration!");
            this.getLogger().log(Level.WARNING, "To activate it, set the value 'enabled' to true!");
            this.getLogger().log(Level.WARNING, "Plugin will be disabled!");
            this.setEnabled(false);
            return;
        }
        this.configuration.start();
        try {
            this.discordBot.start();
        } catch (LoginException ex) {
            this.getLogger().log(Level.SEVERE, ex.getMessage());
        } catch (RateLimitedException ex) {
            this.getLogger().log(Level.SEVERE, ex.getMessage());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        boolean bool = configuration.get("enabled");
        if (!bool) {
            return;
        }
        this.discordBot.stop();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public DiscordBot getDiscordBot() {
        return discordBot;
    }
}
