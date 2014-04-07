package Galaxar.Mod.Blocks;

import Galaxar.Mod.TileEntitys.TileEntityGalaxarChest;
import Galaxar.Mod.TileEntitys.TileEntityWorldMiner;
import Galaxar.Mod.TileEntitys.worldMinerFuelSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WorldMinerContainer extends Container {

	private TileEntityWorldMiner worldMiner;
	
	public WorldMinerContainer(InventoryPlayer invPlayer, TileEntityWorldMiner entity){
		worldMiner = entity;
		
		getPlayerInventory(invPlayer);
		addContainerSlots(entity);
	}
	
	private void addContainerSlots(TileEntityWorldMiner entity)
	{
		addSlotToContainer(new worldMinerFuelSlot(entity, 0, 100, 100));
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
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i){
		Slot slot = getSlot(i);
		
		if(slot != null)
		{
			if(slot.getStack() != null)
			{
				if(slot.getStack().itemID != Item.coal.itemID)
					return null;
			}
		}
		
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
			else if(!mergeItemStack(itemstack, 36, 36 + worldMiner.getSizeInventory(), false))
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
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return worldMiner.isUseableByPlayer(entityplayer);
	}
	
}
