package me.xemor.duplicateeverything;

import org.bukkit.plugin.java.JavaPlugin;

public final class DuplicateEverything extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new DuplicateBlocks(), this);
        this.getServer().getPluginManager().registerEvents(new DuplicateMobs(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
