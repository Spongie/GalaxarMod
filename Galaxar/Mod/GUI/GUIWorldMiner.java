package Galaxar.Mod.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import Galaxar.Mod.Blocks.WorldMinerContainer;
import Galaxar.Mod.TileEntitys.TileEntityWorldMiner;

public class GUIWorldMiner extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation("galaxar", "textures/GUI/GalaxarChest.png");
	
	public GUIWorldMiner(InventoryPlayer invPlayer, TileEntityWorldMiner miner) {
		super(new WorldMinerContainer(invPlayer, miner));
		xSize = 256;
		ySize = 256;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
