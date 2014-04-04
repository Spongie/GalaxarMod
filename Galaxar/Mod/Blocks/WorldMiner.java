package Galaxar.Mod.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Galaxar.Mod.MainMod;
import Galaxar.Mod.TileEntitys.TileEntityGalaxarChest;
import Galaxar.Mod.TileEntitys.TileEntityWorldMiner;
import cpw.mods.fml.common.network.FMLNetworkHandler;

public class WorldMiner extends BlockContainer {

	public WorldMiner(int par1, Material par2Material) {
		super(par1, par2Material);
		setUnlocalizedName("worldMiner");
		setCreativeTab(MainMod.galaxarCreativeTab);
		setHardness(6.5f);
		setResistance(10.0f);
		setTextureName("galaxar:worldMiner");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWorldMiner(1, 5, 1);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, MainMod.instance, 1, world, x, y, z);
		}
		return true;
	}

	
}
