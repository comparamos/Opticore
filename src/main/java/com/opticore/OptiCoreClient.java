package com.opticore;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public final class OptiCoreClient implements ClientModInitializer {
    private static final int[] FPS_LIMITS = {60, 120, 144, 260};
    private static final String[] LABELS = {"60 FPS", "120 FPS", "144 FPS", "Ilimitados"};
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
                currentPreset = (currentPreset + 1) % FPS_LIMITS.length;
                client.options.getMaxFps().setValue(FPS_LIMITS[currentPreset]);
                client.options.write();

                if (client.player != null) {
                    client.player.sendMessage(
                            Text.literal("OptiCore: límite de FPS " + LABELS[currentPreset]),
                            true
                    );
                }
            }
        });
    }
}
