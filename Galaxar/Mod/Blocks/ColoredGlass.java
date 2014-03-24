package Galaxar.Mod.Blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Galaxar.Mod.MainMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class ColoredGlass extends Block {

	private final int dropAmount = 1;
	
	public ColoredGlass(int par1) {
		super(par1, Material.glass);
		setStepSound(soundGlassFootstep);
		setHardness(0.3f);
		setCreativeTab(MainMod.galaxarCreativeTab);
	}
	
	public int idDropped(int metadata, Random random, int fortune)
	{
		return MainMod.darkPlanks.blockID;
	}
	
	public int quantityDropped(Random random)
	{
		return dropAmount;
	}
	
	@Override
    public boolean isOpaqueCube()
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }
}
