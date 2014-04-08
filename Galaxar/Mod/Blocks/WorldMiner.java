package Galaxar.Mod.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import Galaxar.Mod.MainMod;
import Galaxar.Mod.TileEntitys.TileEntityWorldMiner;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldMiner extends BlockContainer {

	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon otherIcon;
	@SideOnly(Side.CLIENT)
	public static Icon botIcon;
	
	public WorldMiner(int par1, Material par2Material) {
		super(par1, par2Material);
		setUnlocalizedName("worldMiner");
		setCreativeTab(MainMod.galaxarCreativeTab);
		setHardness(6.5f);
		setResistance(10.0f);
		//setTextureName("galaxar:worldMiner");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		topIcon = icon.registerIcon("galaxar:worldMinerTop");
		otherIcon = icon.registerIcon("galaxar:worldMiner");
		botIcon = icon.registerIcon("galaxar:worldMinerBot");
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		if(side == 1)
			return topIcon;
		else if(side == 0)
			return botIcon;
		else
			return otherIcon;
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
