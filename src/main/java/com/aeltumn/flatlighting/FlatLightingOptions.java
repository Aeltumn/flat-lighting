package com.aeltumn.flatlighting;

import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.network.chat.Component;

public class FlatLightingOptions {
    public static final OptionInstance<Boolean> CARDINAL_LIGHTING = OptionInstance.createBoolean(
            "flat_lighting.options.cardinal_lighting.name",
            OptionInstance.cachedConstantTooltip(Component.translatable("flat_lighting.options.cardinal_lighting.description")),
            FlatLightingConfig.get().cardinalLighting,
            (newValue) -> {
                var config = FlatLightingConfig.get();
                config.cardinalLighting = newValue;
                config.save();

                var levelRenderer = Minecraft.getInstance().levelRenderer;
                if (levelRenderer != null) {
                    levelRenderer.allChanged();
                }
            });
}
