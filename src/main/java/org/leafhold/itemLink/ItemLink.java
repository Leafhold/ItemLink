package org.leafhold.itemLink;

import org.bukkit.plugin.java.JavaPlugin;

import org.leafhold.itemLink.listeners.ChatListener;

public final class ItemLink extends JavaPlugin {
    private static ItemLink instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getLogger().info("ItemLink has been successfully enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ItemLink has been successfully disabled!");
    }

    public static ItemLink getInstance() {
        return instance;
    }
}
