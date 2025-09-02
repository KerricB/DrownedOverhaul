package com.kerric.drownedoverhaul;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class DrownedGrabManager {
    private final JavaPlugin plugin;
    private final Map<UUID, Set<UUID>> playerToDrowned = new HashMap<>();
    private final int maxGrabs;
    private final double pullStrength;
    private final double grabRange;

    public DrownedGrabManager(JavaPlugin plugin) {
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
        this.maxGrabs = config.getInt("max-grabbing-drowned", 4);
        this.pullStrength = config.getDouble("pull-strength-per-drowned", 0.15);
        this.grabRange = config.getDouble("grab-range", 6.0);
        startDraggingLoop();
    }

    /** Resolve particle name across Bukkit/Paper variants. */
    private Particle splashParticle() {
        try { return Particle.valueOf("WATER_SPLASH"); } // newer name
        catch (IllegalArgumentException ignored) { return Particle.valueOf("SPLASH"); } // fallback
    }

    public void tryGrab(Player player, Drowned drowned) {
        UUID playerId = player.getUniqueId();
        UUID drownedId = drowned.getUniqueId();

        playerToDrowned.putIfAbsent(playerId, new HashSet<>());
        Set<UUID> grabbed = playerToDrowned.get(playerId);

        if (grabbed.size() < maxGrabs && !grabbed.contains(drownedId)) {
            grabbed.add(drownedId);

            drowned.setAI(false);
            drowned.setGravity(false);
            drowned.setRotation(drowned.getLocation().getYaw(), 0.0f);

            plugin.getLogger().info("Drowned latched onto player: " + player.getName());
        }
    }

    public void release(Player player, Drowned drowned) {
        UUID playerId = player.getUniqueId();
        UUID drownedId = drowned.getUniqueId();

        Set<UUID> grabbed = playerToDrowned.get(playerId);
        if (grabbed != null) {
            grabbed.remove(drownedId);
            if (grabbed.isEmpty()) {
                playerToDrowned.remove(playerId);
            }
        }

        drowned.setAI(true);
        drowned.setGravity(true);
    }

    private void startDraggingLoop() {
        new BukkitRunnable() {
            @Override
            public void run() {
                // iterate over a copy in case we remove entries
                for (UUID playerId : new HashSet<>(playerToDrowned.keySet())) {
                    Player player = Bukkit.getPlayer(playerId);
                    if (player == null || !player.isOnline()) continue;

                    Set<UUID> drownedIds = playerToDrowned.get(playerId);
                    if (drownedIds == null) continue;

                    int activeGrabs = 0;

                    for (UUID drownedId : new HashSet<>(drownedIds)) {
                        Entity e = Bukkit.getEntity(drownedId);
                        if (e instanceof Drowned drowned && !e.isDead()) {
                            double distance = drowned.getLocation().distance(player.getLocation());
                            if (distance <= grabRange) {
                                activeGrabs++;

                                Vector direction = player.getLocation().toVector()
                                        .subtract(drowned.getLocation().toVector())
                                        .normalize();

                                // face the player while latched
                                drowned.teleport(drowned.getLocation().setDirection(direction));
                                drowned.setAI(false);
                                drowned.setGravity(false);
                            } else {
                                release(player, drowned);
                            }
                        }
                    }

                    if (activeGrabs > 0) {
                        double pullForce = -pullStrength * activeGrabs; // downward
                        player.setVelocity(player.getVelocity().clone().add(new Vector(0.0, pullForce, 0.0)));

                        player.getWorld().spawnParticle(
                                splashParticle(),
                                player.getLocation().add(0.0, 1.0, 0.0),
                                20, 0.5, 0.5, 0.5, 0.1
                        );

                        player.sendTitle("", "§3" + activeGrabs + " Drowned are holding you underwater!", 0, 20, 10);
                    }
                }
            }
        }.runTaskTimer(this.plugin, 0L, 20L); // every 20 ticks (1s)
    }
}
