package com.aeltumn.flatlighting.mixin;

import net.minecraft.client.renderer.block.model.BakedQuad;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BakedQuad.class)
public class BakedQuadMixin {

    /**
     * @author Aeltumn
     * @reason Change all quads to have no shading.
     */
    @Overwrite
    public boolean isShade() {
        return false;
    }
}
