# OptiCore

Mod cliente sencillo para **Minecraft Java 1.21.1 + Fabric**. Añade un atajo para cambiar el límite de FPS entre 60, 120, 144 y la opción máxima de Minecraft (mostrada como «Ilimitados»).

## Uso

1. Instala Fabric Loader para Minecraft 1.21.1 y Fabric API.
2. Copia el archivo `.jar` de OptiCore a la carpeta `mods`.
3. Pulsa **F6** para cambiar al siguiente límite. Puedes reasignar la tecla en **Opciones → Controles → Asignación de teclas → OptiCore**.

El juego, VSync, el monitor, el controlador gráfico o el sistema pueden imponer límites externos. Desactiva VSync en las opciones del juego si quieres probar FPS por encima de la frecuencia de refresco.

## Compilar

Se necesita Java 21 y Gradle 8.8. Desde la raíz del proyecto, ejecuta:

```sh
gradle build
```

El mod compilado aparece en `build/libs/opticore-fabric-1.21.1-1.0.0.jar`. GitHub Actions lo compila automáticamente al subir cambios; descarga el archivo desde **Actions → última ejecución → Artifacts**.

## Alcance

Este proyecto solo cambia la opción de límite de FPS de Minecraft. No implementa optimizaciones de renderizado ni promete reducir el uso de RAM o multiplicar los FPS. El rendimiento depende del equipo, la configuración y los mods instalados.
