package Galaxar.Mod.Items;

import Galaxar.Mod.MainMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GreenDyeBucket extends Item {
	
	public GreenDyeBucket(int id) {
		super(id);
		setUnlocalizedName("greenBucketDye");
		setTextureName("galaxar:greenDye");
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
