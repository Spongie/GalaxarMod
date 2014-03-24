package Galaxar.Mod.Items;

import Galaxar.Mod.MainMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class DarkPlankSword extends ItemSword {

	public DarkPlankSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		setUnlocalizedName("darkPlankSword");
		setTextureName("galaxar:darkPlankSword");
		setCreativeTab(MainMod.galaxarCreativeTab);
	}

}
