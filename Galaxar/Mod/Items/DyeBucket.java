package Galaxar.Mod.Items;

import Galaxar.Mod.MainMod;
import net.minecraft.item.Item;

public class DyeBucket extends Item {

	public DyeBucket(int id) {
		super(id);
		setUnlocalizedName("bucketDye");
		setTextureName("galaxar:baseDye");
		setCreativeTab(MainMod.galaxarCreativeTab);
	}

}
