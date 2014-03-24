package Galaxar.Mod.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Galaxar.Mod.MainMod;
import Galaxar.Mod.TileEntitys.TileEntityGalaxarChest;
import cpw.mods.fml.common.network.FMLNetworkHandler;

public class GalaxarChest extends BlockContainer {

	public GalaxarChest(int id, Material material) {
		super(id, material);
		setUnlocalizedName("galaxarChest");
		setCreativeTab(MainMod.galaxarCreativeTab);
		setHardness(5.0f);
		setResistance(10.0f);
		setTextureName("galaxar:galaxarChest");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGalaxarChest();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, MainMod.instance, 0, world, x, y, z);
		}
		return true;
	}

}
