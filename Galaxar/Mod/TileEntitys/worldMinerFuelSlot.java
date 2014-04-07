package Galaxar.Mod.TileEntitys;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class worldMinerFuelSlot extends Slot {

	public worldMinerFuelSlot(IInventory par1iInventory, int par2, int par3,
			int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemStack)
    {
		if(itemStack.itemID == Item.coal.itemID)
		{
			ItemStack currentContent = inventory.getStackInSlot(0);
			if(currentContent == null)
				return true;
			else if(currentContent.getItemDamage() == itemStack.getItemDamage())
				return true;
			else 
				return false;
		}
		return false;
    }
}
