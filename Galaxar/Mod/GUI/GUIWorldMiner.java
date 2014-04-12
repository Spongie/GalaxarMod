package Galaxar.Mod.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import Galaxar.Mod.Blocks.WorldMinerContainer;
import Galaxar.Mod.TileEntitys.TileEntityWorldMiner;

public class GUIWorldMiner extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation("galaxar", "textures/GUI/worldMiner.png");
	public static final ResourceLocation progressBar = new ResourceLocation("galaxar", "textures/GUI/progress.png");
	TileEntityWorldMiner miner;
	
	public GUIWorldMiner(InventoryPlayer invPlayer, TileEntityWorldMiner miner) {
		super(new WorldMinerContainer(invPlayer, miner));
		xSize = 176;
		ySize = 209;
		this.miner = miner;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(progressBar);
		drawTexturedModalRect(guiLeft + 31, guiTop + 9, 0, 0, (int)(47 * miner.getBurnedPercentage()), 16);
	}
}
