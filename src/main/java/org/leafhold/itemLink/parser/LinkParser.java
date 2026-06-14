package org.leafhold.itemLink.parser;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import org.leafhold.itemLink.ItemLink;
import org.leafhold.itemLink.parser.ComponentBuilder;

import java.util.regex.Pattern;

public class LinkParser {
    private final ItemLink itemLink;
    private final Pattern placeholderPattern = Pattern.compile("\\[(item|hand|i)\\]", Pattern.CASE_INSENSITIVE);

    public LinkParser(ItemLink itemLink) {
        this.itemLink = itemLink;
    }

    public Component parsePlaceholders(Player player, Component message) {
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        if (heldItem.getType().equals(Material.AIR)) {
            return message;
        }

        Component itemComponent = ComponentBuilder.createItemComponent(heldItem);
        TextReplacementConfig replacementConfig = TextReplacementConfig.builder()
                .match(placeholderPattern)
                .replacement(itemComponent)
                .build();

        return message.replaceText((replacementConfig));
    }
}
