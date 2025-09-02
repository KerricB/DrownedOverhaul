# DrownedOverhaul  
*A Deep Sea Threat Awaits* 🌊  

[![Build](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/KerricB/DrownedOverhaul)
![Java 21](https://img.shields.io/badge/Java-21-007396)
![Paper API](https://img.shields.io/badge/API-Paper%201.21.x-2ea44f)
[![Modrinth](https://img.shields.io/badge/Modrinth-Page-brightgreen?logo=modrinth)](https://modrinth.com/plugin/drownedoverhaul-a-deep-sea-threat-awaits)
[![License: ARR](https://img.shields.io/badge/license-All%20Rights%20Reserved-red.svg)](LICENSE)

---

## 📖 Overview
**DrownedOverhaul** transforms Minecraft’s oceans into a place of genuine peril.  
This plugin reimagines the behavior of Drowned mobs, letting them grab players underwater and drag them toward the depths.

### Features
- **Drowned Grab Mechanic**: Drowned mobs can now latch onto players underwater.  
- **Multi-Grab Support**: Up to **4** drowned can pull a single player, increasing drag force.  
- **Configurable Settings**: Server owners can tweak grab range, pull strength, max grabs, and more.  
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
To apply changes, restart the server or use /reload confirm (restart recommended).

📥 Installation

Download the latest release from Modrinth
 or GitHub Releases.

Place the DrownedOverhaul-x.x.x.jar into your server’s plugins folder.

Start/restart your server.

Adjust config.yml if desired.

🧩 Compatibility
Platform	Status
Paper	✅ Supported (tested 1.21.8)
Spigot	✅ Supported (API only used)
Purpur	⚠️ Likely works, not officially tested
Folia	⚠️ Untested

📌 Technical Notes
- Built against Paper API 1.21.8.
- Uses scheduled tasks for smooth grabbing behavior.
- Plugin auto-loads on server startup, no setup folders required.
- Packaged with Maven for easy dependency management and future updates.

📜 License

This project is licensed under All Rights Reserved (ARR).
You may not redistribute, modify, or rehost this plugin without explicit permission.

🧑 Author

Created by ItsEminus 🎶 (aka Eminus).
Check out more of my work:
- [Modrinth Profile](https://modrinth.com/user/ItsEminus)
- [Spotify – Eminus](https://open.spotify.com/artist/4QJFc32Jjf6H7gJwdbSrPq?si=LQajZ6otQimBnS0k6JGOlA)
