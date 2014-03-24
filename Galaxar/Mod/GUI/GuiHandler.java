package Galaxar.Mod.GUI;

import Galaxar.Mod.MainMod;
import Galaxar.Mod.Blocks.GalaxarChestContainer;
import Galaxar.Mod.TileEntitys.TileEntityGalaxarChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public GuiHandler(){
		NetworkRegistry.instance().registerGuiHandler(MainMod.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		switch(ID)
		{
			case 0:
			if(entity != null && entity instanceof TileEntityGalaxarChest){
				return new GalaxarChestContainer(player.inventory, (TileEntityGalaxarChest)entity);
			}
			else
			{
				return null;
			}
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		switch(ID)
		{
			case 0:
			if(entity != null && entity instanceof TileEntityGalaxarChest){
				return new GUIGalaxarChest(player.inventory, (TileEntityGalaxarChest)entity);
			}
			else
			{
				return null;
			}
			default:
				return null;
		}
	}
	
}
