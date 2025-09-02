package com.kerric.drownedoverhaul;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public final class DrownedOverhaul extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("DrownedOverhaul enabled on " + getServer().getBukkitVersion());

        // create default config if missing
        saveDefaultConfig();

        // wire up managers/listeners (stubs for now)
        DrownedGrabManager grabManager = new DrownedGrabManager(this);

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerWaterMonitor(this, grabManager), this);
        pm.registerEvents(new DrownedAttackHandler(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("DrownedOverhaul disabled.");
    }
}
