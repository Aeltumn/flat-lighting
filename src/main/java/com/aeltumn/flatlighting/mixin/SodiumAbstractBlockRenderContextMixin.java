package com.aeltumn.flatlighting.mixin;

import net.caffeinemc.mods.sodium.client.render.frapi.render.AbstractBlockRenderContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AbstractBlockRenderContext.class)
public class SodiumAbstractBlockRenderContextMixin {
    @ModifyArg(method = "shadeQuad", at = @At(value = "INVOKE", target = "Lnet/caffeinemc/mods/sodium/client/model/light/LightPipeline;calculate(Lnet/caffeinemc/mods/sodium/client/model/quad/ModelQuadView;Lnet/minecraft/core/BlockPos;Lnet/caffeinemc/mods/sodium/client/model/light/data/QuadLightData;Lnet/minecraft/core/Direction;Lnet/minecraft/core/Direction;ZZ)V"), index = 5)
    private boolean hasShade(boolean b) {
        return false;
    }
}
