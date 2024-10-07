# Final Reality Tactics

This is a Scala-based structure for a turn-based RPG that revolves around units, players, items, and a task scheduler. The project is designed to handle game mechanics such as action bars, panels, weapons, potions, and player management.

## Table of Contents

- [Project Structure](#project-structure)
- [Usage](#usage)
    - [Creating Units](#creating-units)
    - [Task Scheduler](#task-scheduler)
    - [Panels](#panels)
    - [Weapons and Items](#weapons-and-items)

## Project Structure

The project is organized into several packages, each of which encapsulates core features of the game:

```
├── api
│   └── GameObject.scala       # Base trait for all game objects for the visualizer
├── model
│   ├── items                  # Contains items, weapons, and potions
│   ├── panels                 # Contains panel objects and interactions
│   ├── players                # Defines players and their logic
│   ├── scheduler              # Handles task scheduling and action bar management
│   └── units                  # Contains unit definitions (characters, enemies)
└── util
    └── Json.scala             # Utility to convert objects into JSON
```

### Core Modules:

1. **api**: Defines the `GameObject` trait, which every entity in the game implements for the visualizer. This trait is the root of the game's object hierarchy.

2. **model.items**: Defines different types of game items, including:
    - `Item`: The base interface for all items.
    - `Weapon` and `MagicWeapon`: Extend `Item` with properties like `attackPoints`, `weight`, and `magicAttackPoints`.
    - `Potion`: Represents usable items in the game, like potions.

3. **model.panels**: Handles the game's panel system. A `Panel` contains units and can be connected to other panels (north, south, east, west).

4. **model.players**: Contains the `Player` and `IPlayer` traits, defining core methods for managing units and tracking defeat states.

5. **model.scheduler**: Implements the task scheduler system with action bars for units.
    - `TaskScheduler`: Stores units and tracks their action bar progress.
    - `ActionBar`: Manages the state of each unit's action bar.

6. **model.units**: Defines `Units`, which includes both enemies and characters. Characters can wield items, weapons, and magical items.

7. **util.Json**: A utility package for converting objects to JSON format, useful for saving/loading game states.

## Usage

### Creating Units

You can create different types of units in the game such as enemies and characters, each with their own attributes like health points (HP), defense points (DP), and weight. Here's an example of creating an `Enemy`:

```scala
val enemy = new Enemy("Orc", 100, 50, 20, 30)
println(enemy.getName)  // Outputs: Orc
```

### Task Scheduler

The `TaskScheduler` is used to manage the order of unit actions based on their action bars. You can add units, calculate their action bar maximums, and increase their action bars over time.

```scala
val scheduler = new TaskScheduler
scheduler.addUnit(enemy)
scheduler.calculateActionBarMax()
scheduler.increaseActionBars(5.0)
```

### Panels

Panels represent tiles or locations in the game. You can create a panel and connect it to neighboring panels (north, south, east, west), and add units to it.

```scala
val panel = new Panel((0, 0), ArrayBuffer(enemy), None, None, None, None)
panel.setNorth(Some(new Panel((0, 1), ArrayBuffer())))
```

### Weapons and Items

You can create weapons, assign them to characters, and manage their attack points and weights.

```scala
val sword = new AbstractWeapon("Sword", 10, 5, character)
sword.setAttackPoints(15)
println(sword.getAttackPoints)  // Outputs: 15
```