package Galaxar.Mod.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Galaxar.Mod.MainMod;

public class BlueDyeBucket extends Item {
	
	public BlueDyeBucket(int id) {
		super(id);
		setUnlocalizedName("blueBucketDye");
		setTextureName("galaxar:blueDye");
		setCreativeTab(MainMod.galaxarCreativeTab);
		setMaxDamage(7);
	}

	@Override
	public boolean hasContainerItem()
	{
		return true;
	}
	
	@Override
	public ItemStack getContainerItemStack(ItemStack itemStack)
	{
		int alter = itemStack.getItemDamage() + 1;
		itemStack.setItemDamage(alter);
		return itemStack;
	}
	
	@Override 
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack)
	{
		return false;
	}

}
