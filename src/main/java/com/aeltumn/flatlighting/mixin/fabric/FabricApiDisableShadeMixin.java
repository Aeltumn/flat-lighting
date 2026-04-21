package com.aeltumn.flatlighting.mixin.fabric;

import com.aeltumn.flatlighting.FlatLightingConfig;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.fabricmc.fabric.impl.client.indigo.renderer.mesh.EncodingFormat;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(value = EncodingFormat.class, remap = false)
public class FabricApiDisableShadeMixin {

    /**
     * Override calls to extract whether a quad is shaded from the format directly
     * whenever cardinal lighting is disabled.
     */
    @WrapMethod(method = "diffuseShade(I)Z")
    private static boolean hasShade(int bits, Operation<Boolean> original) {
        if (!FlatLightingConfig.get().cardinalLighting) return false;
        return original.call(bits);
    }
}

