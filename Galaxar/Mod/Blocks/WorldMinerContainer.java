package Galaxar.Mod.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Galaxar.Mod.TileEntitys.TileEntityGalaxarChest;
import Galaxar.Mod.TileEntitys.TileEntityWorldMiner;
import Galaxar.Mod.TileEntitys.worldMinerFuelSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WorldMinerContainer extends Container {

	private TileEntityWorldMiner worldMiner;
	private int lastConsumed;
	private int lastTicks;

	public WorldMinerContainer(InventoryPlayer invPlayer,
			TileEntityWorldMiner entity) {
		worldMiner = entity;

		getPlayerInventory(invPlayer);
		addContainerSlots(entity);
	}

	private void addContainerSlots(TileEntityWorldMiner entity) {
		addSlotToContainer(new worldMinerFuelSlot(entity, 0, 8, 9));

	}

	private void getPlayerInventory(InventoryPlayer invPlayer) {
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 186));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9,
						8 + x * 18, 128 + y * 18));
			}
		}
	}

	public void addCraftingToCrafters(ICrafting par1ICrafting) {
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0,
				this.worldMiner.ticksOccured);
		par1ICrafting.sendProgressBarUpdate(this, 1,
				this.worldMiner.consumedFuel);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);

			if (this.lastTicks != this.worldMiner.ticksOccured) {
				icrafting.sendProgressBarUpdate(this, 0,
						this.worldMiner.ticksOccured);
			}

			if (this.lastConsumed != this.worldMiner.consumedFuel) {
				icrafting.sendProgressBarUpdate(this, 1,
						this.worldMiner.consumedFuel);
			}
		}

		this.lastConsumed = this.worldMiner.consumedFuel;
		this.lastTicks = this.worldMiner.ticksOccured;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.worldMiner.ticksOccured = par2;
		}

		if (par1 == 1) {
			this.worldMiner.consumedFuel = par2;
		}

	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		Slot slot = getSlot(i);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack = slot.getStack();
			ItemStack result = itemstack.copy();
			if (result.itemID != Item.coal.itemID)
				return null;
			if (i >= 36) {
				if (!mergeItemStack(itemstack, 0, 36, false)) {
					return null;
				}
			} else if (!mergeItemStack(itemstack, 36,
					36 + worldMiner.getSizeInventory(), false)) {
				return null;
			}
			if (itemstack.stackSize == 0) {
				slot.putStack(null);
			} else {
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
