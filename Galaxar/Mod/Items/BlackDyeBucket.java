package Galaxar.Mod.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Galaxar.Mod.MainMod;

public class BlackDyeBucket extends Item {
	
	public BlackDyeBucket(int id) {
		super(id);
		setUnlocalizedName("blackBucketDye");
		setTextureName("galaxar:blackDye");
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
