package net.coordinate.viewer.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.Gui;
import net.minecraft.src.GuiIngame;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class GuiShowCoordinates extends Gui{

    private Minecraft mc;

    public GuiShowCoordinates(Minecraft var1) {
        this.mc = var1;
    }

    @Inject(method = "func_4066_a", at = @At("TAIL"))
    private void showText(float var1, boolean var2, int var3, int var4, CallbackInfo ci){
        this.showCoordinates((int)this.mc.field_6322_g.posX, (int)this.mc.field_6322_g.posY, (int)this.mc.field_6322_g.posZ, Keyboard.isKeyDown(61));
    }

    public void showCoordinates(int x, int y, int z, boolean showDown){
        this.mc.field_6314_o.drawStringWithShadow("Position: " + x + ", " + y + ", " + z, 2, showDown ? 42: 12, 16777215);
    }

}
