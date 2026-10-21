package net.pcal.splitscreen.common.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.pcal.splitscreen.common.Mod.mod;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "toggleFullscreen()V", at = @At("HEAD"), cancellable = true, remap = false)
    private void splitscreen_toggleFullscreen(CallbackInfo ci) {
        mod().onToggleFullscreen((net.pcal.splitscreen.common.MinecraftWindow) (Object) Minecraft.getInstance().getWindow());
        ci.cancel();
    }
}
