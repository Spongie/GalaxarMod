package Galaxar.Mod.TileEntitys;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWorldMiner extends TileEntity implements IInventory {

	ItemStack[] inventory;
	private int consumedFuel;
	private int fuelToGenerateItem;
	
	private int minGeneratedItems;
	private int maxGeneratedItems;
	
	public TileEntityWorldMiner(int min, int max, int fuelReq)
	{
		inventory = new ItemStack[1];
		minGeneratedItems = min;
		maxGeneratedItems = max;
		consumedFuel = 0;
		fuelToGenerateItem = fuelReq;
	}
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) {
		ItemStack itemStack = getStackInSlot(slot);
		if(itemStack != null)
		{
			if(itemStack.stackSize >= count){
				setInventorySlotContents(slot, null);
			}
			else
			{
				itemStack = itemStack.splitStack(count);
				onInventoryChanged();
			}
		}
		return itemStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack itemStack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return itemStack;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
		{
			itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}

	@Override
	public String getInvName() {
		return "Galaxar Chest";
	}

	@Override
	public boolean isInvNameLocalized() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < getSizeInventory(); i++)
		{
			ItemStack stack = getStackInSlot(i);
			if(stack != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				
				item.setByte("SlotGalaxarChest", (byte)i);
				stack.writeToNBT(item);
				list.appendTag(item);
			}
		}
		
		compound.setTag("ItemsGalaxarChest", list);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList list = compound.getTagList("ItemsGalaxarChest");
		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound item = (NBTTagCompound) list.tagAt(i);
			int slot = item.getByte("SlotGalaxarChest");
			if(slot >= 0 && slot < getSizeInventory()) {
				  setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
				}
		}
	}
	
	
	public int tickRate()
	{
		//value % 20 = seconds between updates
		return 20;
	}
	
	public void updateEntity()
	{
		if(inventory[0].stackSize > 1)
		{
			consumedFuel += 1;
			inventory[0].stackSize--;
		}
	}
}
