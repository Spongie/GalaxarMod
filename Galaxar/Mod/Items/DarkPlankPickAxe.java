package Galaxar.Mod.Items;

import Galaxar.Mod.MainMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class DarkPlankPickAxe extends ItemPickaxe {

	public DarkPlankPickAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		setUnlocalizedName("darkPlankPickAxe");
		setTextureName("galaxar:darkPlankPickAxe");
		setCreativeTab(MainMod.galaxarCreativeTab);
	}

}
