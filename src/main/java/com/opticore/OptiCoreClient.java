package com.opticore;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public final class OptiCoreClient implements ClientModInitializer {
    private static final int UNLIMITED_FRAMERATE = 260;
    private static final FpsPreset[] FPS_PRESETS = {
            new FpsPreset(60, "fps.opticore.preset.60"),
            new FpsPreset(120, "fps.opticore.preset.120"),
            new FpsPreset(144, "fps.opticore.preset.144"),
            new FpsPreset(UNLIMITED_FRAMERATE, "fps.opticore.preset.unlimited")
    };
    private int currentPreset = 0;
    private KeyBinding cycleFpsKey;

    @Override
    public void onInitializeClient() {
        cycleFpsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.opticore.cycle_fps",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F6,
                "category.opticore.controls"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (cycleFpsKey.wasPressed()) {
                currentPreset = (currentPreset + 1) % FPS_PRESETS.length;
                FpsPreset preset = FPS_PRESETS[currentPreset];
                client.options.getMaxFps().setValue(preset.limit());
                client.options.write();

                if (client.player != null) {
                    client.player.sendMessage(
                            Text.translatable(
                                    "message.opticore.fps_limit_changed",
                                    Text.translatable(preset.translationKey())
                            ),
                            true
                    );
                }
            }
        });
    }

    private record FpsPreset(int limit, String translationKey) {
    }
}
