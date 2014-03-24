package Galaxar.Mod.Items;

import Galaxar.Mod.MainMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class DarkPlankHoe extends ItemHoe {

	public DarkPlankHoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		setUnlocalizedName("darkPlankHoe");
		setTextureName("galaxar:darkPlankHoe");
		setCreativeTab(MainMod.galaxarCreativeTab);
	}

}
