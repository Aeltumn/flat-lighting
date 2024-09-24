package com.aeltumn.flatlighting.mixin;

import net.minecraft.client.renderer.block.model.BakedQuad;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Run at the highest priority so we go last!
@Mixin(value = BakedQuad.class, priority = 1000000)
public class DisableQuadShadeMixin {

    /**
     * Change all quads to have no shading.
     *
     * @author Aeltumn
     */
    @Inject(method = "isShade", at = @At("HEAD"), cancellable = true)
    public void isShade(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
