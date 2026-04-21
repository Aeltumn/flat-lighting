package com.aeltumn.flatlighting.mixin;

import com.aeltumn.flatlighting.FlatLightingConfig;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.renderer.block.BlockModelLighter;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

// Run at the highest priority so we go last!
@Mixin(value = BlockModelLighter.class, priority = 1000000)
public class DisableQuadShadeMixin {

    /**
     * Change all quads to have no shading on request.
     *
     * @author Aeltumn
     */
    @WrapOperation(method = "prepareQuadAmbientOcclusion", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/geometry/BakedQuad$MaterialInfo;shade()Z"))
    public boolean isShadedAO(BakedQuad.MaterialInfo instance, Operation<Boolean> original) {
        if (!FlatLightingConfig.get().cardinalLighting) return false;
        return original.call(instance);
    }

    /**
     * Change all quads to have no shading on request.
     *
     * @author Aeltumn
     */
    @WrapOperation(method = "prepareQuadFlat", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/geometry/BakedQuad$MaterialInfo;shade()Z"))
    public boolean isShadedFlat(BakedQuad.MaterialInfo instance, Operation<Boolean> original) {
        if (!FlatLightingConfig.get().cardinalLighting) return false;
        return original.call(instance);
    }
}
