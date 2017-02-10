package com.programmingwizzard.mccord.discord.listeners;

import com.programmingwizzard.mccord.discord.basic.DMessage;
import com.programmingwizzard.mccord.discord.enums.DMessageType;
import com.programmingwizzard.mccord.discord.tasks.ChatRepeater;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public class TextMessageListener extends ListenerAdapter {

    private final ChatRepeater repeater;

    public TextMessageListener(ChatRepeater repeater) {
        this.repeater = repeater;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        DMessage dMessage = new DMessage(event.getAuthor(), event.getMessage(), DMessageType.MINECRAFT);
        repeater.addElement(dMessage);
    }
}
