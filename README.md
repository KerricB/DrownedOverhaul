# 🧟 DrownedOverhaul

A Paper 1.21.8 plugin that overhauls drowned behavior, letting them grab players in water and drag them underwater for a more immersive (and terrifying) ocean survival experience.

---

## ✨ Features
- Drowned can **latch onto players** when nearby in water.  
- Multiple drowned can attach at once (configurable).  
- Latched drowned **pull players underwater** with a configurable force.  
- Customizable range, pull strength, and max latching drowned.  
- Visual feedback: splash particles and title messages when grabbed.  
- Safe release when a drowned dies or the player leaves water.  

---

## ⚙️ Configuration
Default `config.yml`:

```yaml
max-grabbing-drowned: 4
pull-strength-per-drowned: 0.15
grab-range: 6.0
