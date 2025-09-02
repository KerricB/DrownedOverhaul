package com.kerric.drownedoverhaul;

import org.bukkit.entity.Drowned;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerWaterMonitor implements Listener {
    private final JavaPlugin plugin;
    private final DrownedGrabManager grabManager;

    public PlayerWaterMonitor(JavaPlugin plugin, DrownedGrabManager grabManager) {
        this.plugin = plugin;
        this.grabManager = grabManager;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        boolean inLiquid = player.getLocation().getBlock().isLiquid();

        if (inLiquid) {
            // If the player is in water, let nearby drowned try to latch on
            for (Entity e : player.getNearbyEntities(6.0, 6.0, 6.0)) {
                if (e instanceof Drowned d) {
                    grabManager.tryGrab(player, d);
                }
            }
        } else {
            // If the player left water, proactively release nearby latchers
            for (Entity e : player.getNearbyEntities(6.0, 6.0, 6.0)) {
                if (e instanceof Drowned d) {
                    grabManager.release(player, d);
                }
            }
        }
    }
}
