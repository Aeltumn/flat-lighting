package com.aeltumn.flatlighting.mixin;

import me.jellysquid.mods.sodium.client.model.quad.BakedQuadView;
import me.jellysquid.mods.sodium.client.render.chunk.compile.pipeline.BlockRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockRenderer.class)
public class SodiumBlockRendererMixin {

    /**
     * Override the hasShade method to always return false.
     */
    @Redirect(method = "getVertexLight", at = @At(value = "INVOKE", target = "Lme/jellysquid/mods/sodium/client/model/quad/BakedQuadView;hasShade()Z"))
    private boolean injected(BakedQuadView instance) {
        return false;
    }
}
