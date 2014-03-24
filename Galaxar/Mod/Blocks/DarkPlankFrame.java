package Galaxar.Mod.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import Galaxar.Mod.MainMod;
import Galaxar.Mod.Client.ClientProxy;

public class DarkPlankFrame extends Block {

	private final int dropAmount = 1;
	
	public DarkPlankFrame(int id, Material material) {
		super(id, material);
		
		setHardness(0.5f);
		setStepSound(Block.soundWoodFootstep);
		setUnlocalizedName("darkPlankFrame");
		setCreativeTab(MainMod.galaxarCreativeTab);
		setTextureName("galaxar:darkPlankFrame");
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
	

}
