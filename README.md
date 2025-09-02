# DrownedOverhaul  
*A Deep Sea Threat Awaits* 🌊

[![Modrinth] (https://modrinth.com/plugin/drownedoverhaul-a-deep-sea-threat-awaits) 
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
```
Server owners can edit these values and reload/restart their server to apply changes.

🚀 Installation

- Download the latest release from Modrinth.

- Place the .jar file into your server’s plugins/ folder.

- Restart the server to generate the default config.yml.

(Optional) Adjust values in config.yml to fit your server’s playstyle.

🛠️ Technical Notes

- Built with Maven against PaperMC API 1.21.8.

- Uses scheduled tasks for smooth dragging behavior.

- Auto-loads on server startup, no extra setup required.

- Tested for performance and compatibility with Paper and Spigot.

📌 Compatibility

Minecraft Versions: 1.21.4 → 1.21.8

Platforms: Paper, Spigot

🧑 Author

Created by ItsEminus 🎶 (aka Eminus).


📜 License

This project is licensed under All Rights Reserved.
You may not redistribute or modify without permission.
