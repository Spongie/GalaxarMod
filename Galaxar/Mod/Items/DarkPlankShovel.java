package Galaxar.Mod.Items;

import Galaxar.Mod.MainMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class DarkPlankShovel extends ItemSpade {

	public DarkPlankShovel(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		setUnlocalizedName("darkPlankShovel");
		setTextureName("galaxar:darkPlankShovel");
		setCreativeTab(MainMod.galaxarCreativeTab);
	}

}
