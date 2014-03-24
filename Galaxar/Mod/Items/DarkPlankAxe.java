package Galaxar.Mod.Items;

import Galaxar.Mod.MainMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class DarkPlankAxe extends ItemAxe {

	public DarkPlankAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		setUnlocalizedName("darkPlankAxe");
		setTextureName("galaxar:darkPlankAxe");
		setCreativeTab(MainMod.galaxarCreativeTab);
	}

}
