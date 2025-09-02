# DrownedOverhaul  
*A Deep Sea Threat Awaits* 🌊

[![Modrinth] https://modrinth.com/plugin/drownedoverhaul-a-deep-sea-threat-awaits  
[![License: ARR](https://img.shields.io/badge/license-All%20Rights%20Reserved-red.svg)](LICENSE)  

---

## 📖 Overview
**DrownedOverhaul** transforms Minecraft’s oceans into a place of genuine peril.  
This plugin reimagines the behavior of Drowned mobs, letting them grab players underwater and drag them toward the depths.

Features include:
- **Drowned Grab Mechanic**: Drowned mobs can now latch onto players underwater.
- **Multi-Grab Support**: Up to **4** drowned can pull a single player, increasing drag force.
- **Configurable Settings**: Server owners can tweak grab range, pull strength, and more.
- **Failsafe Handling**: Prevents infinite grab loops or buggy escape behavior.
- **Lightweight & Server-Friendly**: Designed for **PaperMC** (works on Spigot/Purpur too).

---

## ⚙️ Configuration
The plugin generates a `config.yml` on first run.  
Default values:
```yaml
# Maximum number of drowned that can grab a player
max-grabbing-drowned: 4

# Strength of the pull applied per drowned (Y-axis force)
pull-strength-per-drowned: 0.15

# Maximum distance at which drowned can latch onto players
grab-range: 6.0
