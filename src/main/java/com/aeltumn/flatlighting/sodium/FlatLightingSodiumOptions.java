package com.aeltumn.flatlighting.sodium;

import com.aeltumn.flatlighting.FlatLightingConfig;
import net.caffeinemc.mods.sodium.api.config.ConfigEntryPoint;
import net.caffeinemc.mods.sodium.api.config.structure.ConfigBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

/**
 * Adds the additional configuration options to Sodium's video settings menu.
 */
public class FlatLightingSodiumOptions implements ConfigEntryPoint {
    @Override
    public void registerConfigLate(ConfigBuilder builder) {
        builder.registerOwnModOptions()
                .setIcon(Identifier.parse("flat-lighting:icon.png"))
                .addPage(builder.createOptionPage()
                        .setName(Component.literal("Flat Lighting"))
                        .addOption(builder.createBooleanOption(Identifier.parse("flat-lighting:cardinal_lighting"))
                                .setName(Component.translatable("flat_lighting.options.cardinal_lighting.name"))
                                .setTooltip(Component.translatable("flat_lighting.options.cardinal_lighting.description"))
                                .setStorageHandler(() -> FlatLightingConfig.get().save())
                                .setBinding((value) -> {
                                    FlatLightingConfig.get().cardinalLighting = value;
                                }, () -> FlatLightingConfig.get().cardinalLighting)
                                .setDefaultValue(FlatLightingConfig.get().cardinalLighting)
                                .setApplyHook((state) -> {
                                    var levelRenderer = Minecraft.getInstance().levelRenderer;
                                    if (levelRenderer != null) {
                                        levelRenderer.allChanged();
                                    }
                                })
                        )
                );
    }
}
