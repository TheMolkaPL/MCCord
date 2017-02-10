package com.programmingwizzard.mccord.discord;

import com.programmingwizzard.mccord.MCCord;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.impl.GameImpl;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public class DiscordBot {

    private final MCCord mcCord;
    private JDA jda;

    public DiscordBot(MCCord mcCord) {
        this.mcCord = mcCord;
    }

    public void start() throws RateLimitedException, InterruptedException, LoginException {
        Configuration configuration = this.mcCord.getConfiguration();
        JDABuilder builder = new JDABuilder(AccountType.BOT);

        // bot settings
        String token = configuration.get("bot.token");

        // game settings
        String gameUrl = configuration.get("bot.game.url");
        String gameName = configuration.get("bot.game.name");
        boolean twitch = configuration.get("bot.game.twitch");
        boolean game = configuration.get("bot.game.enabled");

        // init
        if (token != null) {
            builder.setToken(token);
        }
        if (game && gameName != null) {
            builder.setGame(new GameImpl(gameName, gameUrl, (twitch && gameUrl != null) ? Game.GameType.TWITCH : Game.GameType.DEFAULT));
        }
        builder.setAutoReconnect(true);
        builder.setAudioEnabled(false);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setStatus(OnlineStatus.ONLINE);
        this.jda = builder.buildBlocking();

        // TODO: modules
    }

    public void stop() {
        // TODO
    }

    public MCCord getMcCord() {
        return mcCord;
    }
}
