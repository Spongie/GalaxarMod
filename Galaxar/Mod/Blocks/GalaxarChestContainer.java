package Galaxar.Mod.Blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import Galaxar.Mod.TileEntitys.TileEntityGalaxarChest;

public class GalaxarChestContainer extends Container {
	private TileEntityGalaxarChest galaxarChest;
	
	public GalaxarChestContainer(InventoryPlayer invPlayer, TileEntityGalaxarChest entity){
		galaxarChest = entity;
		
		getPlayerInventory(invPlayer);
		addContainerSlots(entity);
	}
	
	private void getPlayerInventory(InventoryPlayer invPlayer)
	{
		for(int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(invPlayer, i, 53 + i *18, 232));
		}
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9, 53 + x * 18, 174 + y * 18));
			}
		}
	}
	
	private void addContainerSlots(TileEntityGalaxarChest entity)
	{
		for(int y = 0; y < 9; y++) {
			  for(int x = 0; x < 13; x++) {
			        addSlotToContainer(new Slot(entity, x + y * 13, 12 + x * 18, 5 + y * 18));
			  }
			}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i){
		Slot slot = getSlot(i);
		
		if(slot != null && slot.getHasStack())
		{
			ItemStack itemstack = slot.getStack();
			ItemStack result = itemstack.copy();
			if(i >= 36)
			{
				if(!mergeItemStack(itemstack, 0, 36, false))
				{
					return null;
				}
			}
			else if(!mergeItemStack(itemstack, 36, 36 + galaxarChest.getSizeInventory(), false))
			{
				return null;
			}
			if(itemstack.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}
			slot.onPickupFromSlot(player, itemstack);
			return result;
		}
		return null;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player){
		return galaxarChest.isUseableByPlayer(player);
	}

}
