package org.leafhold.itemLink;

import org.bukkit.plugin.java.JavaPlugin;

public final class ItemLink extends JavaPlugin {
    private static ItemLink instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    public static ItemLink getInstance() {
        return instance;
    }
}
