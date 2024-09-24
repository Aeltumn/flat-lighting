package com.aeltumn.flatlighting.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.renderer.block.model.BakedQuad;
import org.spongepowered.asm.mixin.Mixin;

// Run at the highest priority so we go last!
@Mixin(value = BakedQuad.class, priority = 1000000)
public class DisableQuadShadeMixin {

    /**
     * Change all quads to have no shading.
     *
     * @author Aeltumn
     */
    @WrapMethod(method = "isShade")
    public boolean isShade(Operation<Boolean> original) {
        return false;
    }
}
