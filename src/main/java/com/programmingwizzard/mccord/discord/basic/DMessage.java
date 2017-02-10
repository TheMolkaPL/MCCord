package com.programmingwizzard.mccord.discord.basic;

import com.programmingwizzard.mccord.discord.enums.DMessageType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import org.bukkit.entity.Player;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public class DMessage {

    private final String nickname;
    private final String message;
    private final DMessageType type;

    public DMessage(Player player, String message, DMessageType type) {
        this.nickname = player.getName();
        this.message = message;
        this.type = type;
    }

    public DMessage(User user, Message message, DMessageType type) {
        this.nickname = user.getName();
        this.message = message.getRawContent();
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }

    public DMessageType getType() {
        return type;
    }
}
