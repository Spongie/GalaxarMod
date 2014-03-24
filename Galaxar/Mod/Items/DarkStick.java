package Galaxar.Mod.Items;

import Galaxar.Mod.MainMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DarkStick extends Item {

	public DarkStick(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(MainMod.galaxarCreativeTab);
		setUnlocalizedName("darkStick");
		setTextureName("galaxar:darkStick");
	}

}
