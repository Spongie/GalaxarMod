package Galaxar.Mod.TileEntitys;

import java.util.Map;
import java.util.Random;

import cpw.mods.fml.common.network.PacketDispatcher;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityWorldMiner extends TileEntity implements IInventory {

	ItemStack[] inventory;
	private int consumedFuel;
	private int fuelToGenerateItem;
	
	private int minGeneratedItems;
	private int maxGeneratedItems;
	
	private int outX;
	private int outY;
	private int outZ;
	
	private int[] spawnableIDs;
	
	private int ticksOccured;
	
	private int boostLvl;
	
	public TileEntityWorldMiner()
	{
		this(1,5,1);
	}
	
	public TileEntityWorldMiner(int min, int max, int fuelReq)
	{
		boostLvl = 0;
		inventory = new ItemStack[1];
		minGeneratedItems = min;
		maxGeneratedItems = max;
		consumedFuel = 0;
		fuelToGenerateItem = fuelReq;
		initSpawns();
		ticksOccured = 0;
	}
	
	private void initSpawns()
	{
		spawnableIDs = new int[5];
		spawnableIDs[0] = Block.oreCoal.blockID;
		spawnableIDs[1] = Block.oreIron.blockID;
		spawnableIDs[2] = Block.oreGold.blockID;
		spawnableIDs[3] = Block.oreDiamond.blockID;
		spawnableIDs[4] = Block.oreEmerald.blockID;
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
		return "WorldMiner";
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
		
		System.out.println("Derping");
		if(i == 0)
		{
			if(itemstack.itemID == Item.coal.itemID)
			{
				ItemStack currentContent = getStackInSlot(i);
				if(currentContent == null)
					return true;
				else if(currentContent.getItemDamage() == itemstack.getItemDamage())
					return true;
				else 
					return false;
			}
			else
				return false;
			
		}		
		return false;
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
				
				item.setByte("SlotWorldMiner", (byte)i);
				stack.writeToNBT(item);
				list.appendTag(item);
			}
		}
		compound.setTag("ItemsWorldMiner", list);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
		super.readFromNBT(compound);
		NBTTagList list = compound.getTagList("ItemsWorldMiner");
		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound item = (NBTTagCompound) list.tagAt(i);
			int slot = item.getByte("SlotWorldMiner");
			if(slot >= 0 && slot < getSizeInventory()) {
				  setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
				}
		}
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound compound = new NBTTagCompound();
		this.writeToNBT(compound);
		return new Packet132TileEntityData(xCoord, yCoord, zCoord, 1, compound);
	}
	
	public void onDataPacket(INetworkManager networkManager, Packet132TileEntityData packet) {
	    this.readFromNBT(packet.data);
	}
	
	public void updateEntity()
	{
		if(!worldObj.isRemote)
		{
			
		if(hasAdjacentContainer(getWorldObj()))
		{	
			ticksOccured++;
			if(ticksOccured > 40)
			{
				if(inventory[0] != null && inventory[0].stackSize > 0)
				{				
					ticksOccured = 0;
					consumedFuel += 1;
					ItemStack stack = getStackInSlot(0);
					stack.stackSize--;
					if(stack.stackSize <= 1)
						stack = null;
					setInventorySlotContents(0, stack);
					worldObj.markBlockForUpdate(outX, outY, outZ);
				}
				
				if(consumedFuel >= fuelToGenerateItem)
				{
					consumedFuel = 0;
					int idToSpawn = spawnableIDs[getSpawnIndex()];
					int amount = new Random().nextInt(maxGeneratedItems + 1);
					insertItemInChest(idToSpawn, amount);
				}
			}
		}
		else
			ticksOccured = 0;
		
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}
	
	public Block getBlockFromID(int ID)
	{
		if(ID == Block.oreCoal.blockID)
			return Block.oreCoal;
		else if(ID == Block.oreIron.blockID)
			return Block.oreIron;
		else if(ID == Block.oreGold.blockID)
			return Block.oreGold;
		else if(ID == Block.oreDiamond.blockID)
			return Block.oreDiamond;
		else if(ID == Block.oreEmerald.blockID)
			return Block.oreEmerald;
		
		return Block.bed;
	}
	
	private int getSpawnIndex()
	{
		int res = new Random().nextInt(101);
		if(res >= 98 - boostLvl)
			return 4;
		else if(res >= 90 - boostLvl)
			return 3;
		else if(res >= 70 - boostLvl)
			return 2;
		else if(res >= 45 - boostLvl)
			return 1;
		else
			return 0;
		
	}
	
	public int insertItemInChest(int blockID, int amount)
	{
		TileEntity entity = getWorldObj().getBlockTileEntity(outX, outY, outZ);
		if(amount <= 0)
			return -1;
		if(entity != null && entity instanceof IInventory)
		{
			IInventory entInv = (IInventory)entity;
			for(int i = 0; i < entInv.getSizeInventory(); i++)
			{
				ItemStack currentStack = entInv.getStackInSlot(i);
				if(currentStack == null)
				{
					entInv.setInventorySlotContents(i, new ItemStack(getBlockFromID(blockID), amount));
					i = entInv.getSizeInventory();
				}
				else if(currentStack.itemID == blockID)
				{
					
					if(currentStack.stackSize + amount <= 64)
					{
						entInv.setInventorySlotContents(i, new ItemStack(getBlockFromID(blockID), currentStack.stackSize+amount));
						i = entInv.getSizeInventory();
					}
					else
					{
						int remaining = Math.abs(64 - currentStack.stackSize - amount);
						entInv.setInventorySlotContents(i, new ItemStack(getBlockFromID(blockID), 64));
						insertItemInChest(blockID, remaining);
						i = entInv.getSizeInventory();
					}
				}
			}
		}
		return -1;
	}
	
	public boolean hasAdjacentContainer(World world)
	{
		boolean done = false;
		int offX = 1;
		int offY = 0;
		int offZ = 0;
		while(!done)
		{
			TileEntity entity = world.getBlockTileEntity(xCoord + offX, yCoord+ offY, zCoord + offZ);
			if(entity != null)
			{
				if(entity instanceof IInventory)
				{
					if(!isContainerFull((IInventory)entity))
					{
						outX = xCoord + offX;
						outY = yCoord + offY;
						outZ = zCoord + offZ;
						return true;
					}
					
				}
			}
			if(offX == 1)
				offX = -1;
			else if(offX == -1)
			{
				offX = 0;
				offY = 1;
			}
			else if(offY == 1)
				offY = -1;
			else if(offY == -1)
			{
				offY = 0;
				offZ = 1;
			}
			else if(offZ == 1)
				offZ = -1;
			else if(offZ == -1)
				done = true;
		}
		return false;
	}
	
	private boolean isContainerFull(IInventory inv)
	{
		if(inv != null)
		{
			for(int i = 0; i < inv.getSizeInventory(); i++)
			{
				ItemStack current = inv.getStackInSlot(i);
				if(current == null)
					return false;
				else if(current.stackSize < 64)
					return false;
			}
		}
		return true;
	}
}
