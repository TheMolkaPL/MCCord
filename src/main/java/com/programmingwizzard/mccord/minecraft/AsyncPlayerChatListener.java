package com.programmingwizzard.mccord.minecraft;

import com.programmingwizzard.mccord.discord.basic.DMessage;
import com.programmingwizzard.mccord.discord.enums.DMessageType;
import com.programmingwizzard.mccord.discord.tasks.ChatRepeater;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public class AsyncPlayerChatListener implements Listener {

    private final ChatRepeater repeater;

    public AsyncPlayerChatListener(ChatRepeater repeater) {
        this.repeater = repeater;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        DMessage dMessage = new DMessage(event.getPlayer(), event.getMessage(), DMessageType.DISCORD);
        this.repeater.addElement(dMessage);
    }

}
