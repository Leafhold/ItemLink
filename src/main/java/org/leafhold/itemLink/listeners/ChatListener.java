package org.leafhold.itemLink.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;

import net.kyori.adventure.text.Component;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import org.leafhold.itemLink.ItemLink;
import org.leafhold.itemLink.parser.LinkParser;

public class ChatListener implements Listener {
    private final ItemLink itemLink;
    private final LinkParser linkParser;

    public ChatListener(ItemLink itemLink) {
        this.itemLink = itemLink;
        this.linkParser = new LinkParser(itemLink);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerChat(AsyncChatEvent event) {
        Player player = event.getPlayer();
        Component originalMessage = event.message();
        Component parsedMessage = linkParser.parsePlaceholders(player, originalMessage);
        event.message(parsedMessage);
    }
}
