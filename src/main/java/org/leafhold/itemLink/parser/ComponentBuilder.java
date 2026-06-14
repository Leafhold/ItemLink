package org.leafhold.itemLink.parser;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.inventory.ItemStack;

public class ComponentBuilder {
    public static Component createItemComponent(ItemStack item) {
        Component itemName = item.hasItemMeta() && item.getItemMeta().hasDisplayName()
                ? item.getItemMeta().displayName()
                : Component.translatable(item.getType().translationKey());

        return Component.text("[")
                .color(NamedTextColor.GRAY)
                .append(itemName)
                .append(Component.text("]"))
                .hoverEvent(item.asHoverEvent());
    }
}
