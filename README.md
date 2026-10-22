# OptiCore

A simple client-side mod for **Minecraft Java 1.21.1 + Fabric**. It adds a keyboard shortcut to cycle through FPS limits of 60, 120, 144, and Minecraft's maximum FPS setting (displayed as "Unlimited").

## Usage

1. Install Fabric Loader for Minecraft 1.21.1 and Fabric API.
2. Copy the OptiCore `.jar` file into your `mods` folder.
3. Press **F6** to switch to the next FPS limit. You can rebind the key in **Options → Controls → Key Binds → OptiCore**.

The game, VSync, monitor, graphics driver, or operating system may impose additional FPS limits. Disable VSync in the game settings if you want to test FPS values above your monitor's refresh rate.

## Building

Java 21 and Gradle 8.10.2 or newer are required. From the project root, run:

```sh
gradle build
```

The compiled mod will be available at:

```text
build/libs/opticore-fabric-1.21.1-1.0.0.jar
```

GitHub Actions automatically builds the mod when you push changes. Download the compiled file from **Actions → Latest Run → Artifacts**.

## Scope

This project only changes Minecraft's FPS limit setting. It does not implement rendering optimizations or promise to reduce RAM usage or multiply FPS. Performance depends on your hardware, configuration, and installed mods.
