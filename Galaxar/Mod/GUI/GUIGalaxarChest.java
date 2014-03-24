package Galaxar.Mod.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import Galaxar.Mod.Blocks.GalaxarChestContainer;
import Galaxar.Mod.TileEntitys.TileEntityGalaxarChest;

import org.lwjgl.opengl.GL11;


public class GUIGalaxarChest extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation("galaxar", "textures/GUI/GalaxarChest.png");
	
	public GUIGalaxarChest(InventoryPlayer invPlayer, TileEntityGalaxarChest entity) {
		super(new GalaxarChestContainer(invPlayer, entity));
		
		xSize = 256;
		ySize = 256;
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float f, int j, int i){
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
