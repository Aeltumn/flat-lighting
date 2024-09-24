package com.aeltumn.flatlighting.mixin.sodium;

import net.caffeinemc.mods.sodium.client.render.frapi.mesh.MutableQuadViewImpl;
import net.caffeinemc.mods.sodium.client.render.frapi.render.AbstractBlockRenderContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(value = AbstractBlockRenderContext.class, remap = false)
public class SodiumDisableShadeMixin {

    /**
     * Overrides calls to hasShade on a block to always return false, disabling shading.
     */
    @Redirect(method = "shadeQuad", at = @At(value = "INVOKE", target = "Lnet/caffeinemc/mods/sodium/client/render/frapi/mesh/MutableQuadViewImpl;hasShade()Z"))
    private boolean hasShade(MutableQuadViewImpl instance) {
        return false;
    }
}
