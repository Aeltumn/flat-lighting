package com.aeltumn.flatlighting.mixin;

import com.aeltumn.flatlighting.FlatLightingOptions;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.screens.options.VideoSettingsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

/**
 * Adds the ambient occlusion setting to the vanilla's video settings menu.
 */
@Mixin(VideoSettingsScreen.class)
public abstract class VideoSettingsScreenMixin {

    @ModifyReturnValue(method = "qualityOptions", at = @At("TAIL"))
    private static OptionInstance<?>[] changeOptions(OptionInstance<?>[] original) {
        var newOptions = List.of(FlatLightingOptions.CARDINAL_LIGHTING);
        var newArray = new OptionInstance<?>[original.length + newOptions.size()];
        System.arraycopy(original, 0, newArray, 0, original.length);
        for (int i = newOptions.size(); i > 0; i--) {
            newArray[newArray.length - i] = newOptions.get(newOptions.size() - i);
        }
        return newArray;
    }
}
