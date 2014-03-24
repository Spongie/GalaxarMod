package Galaxar.Mod.Blocks;

import java.util.Random;

import Galaxar.Mod.MainMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DarkPlanks extends Block {

	private final int dropAmount = 1;
	
	public DarkPlanks(int id, Material material) {
		super(id, material);
		setHardness(0.5f);
		setStepSound(Block.soundWoodFootstep);
		setUnlocalizedName("darkPlanks");
		setCreativeTab(MainMod.galaxarCreativeTab);
		setTextureName("galaxar:darkPlanks");
	}
	
	public int idDropped(int metadata, Random random, int fortune)
	{
		return MainMod.darkPlanks.blockID;
	}
	
	public int quantityDropped(Random random)
	{
		return dropAmount;
	}


}
