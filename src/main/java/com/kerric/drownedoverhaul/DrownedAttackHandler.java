package com.kerric.drownedoverhaul;

import org.bukkit.entity.Drowned;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DrownedAttackHandler implements Listener {
    @EventHandler
    public void onEntityAttack(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Drowned && event.getEntity() instanceof Player) {
            // Prevent drowned from actually damaging the player while they're “grabbing”
            event.setCancelled(true);
        }
    }
}
