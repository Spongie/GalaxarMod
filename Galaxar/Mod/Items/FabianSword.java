package Galaxar.Mod.Items;

import Galaxar.Mod.MainMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class FabianSword extends ItemPickaxe {

	public FabianSword(int id, EnumToolMaterial material) {
		super(id, material);
		setUnlocalizedName("fabianSword");
		setTextureName("galaxar:fabianSword");
		setCreativeTab(MainMod.galaxarCreativeTab);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int id, int x, int y, int z, EntityLivingBase par7EntityLivingBase)
    {
		if(!par2World.isRemote)
		{
		MovingObjectPosition res = this.getMovingObjectPositionFromPlayer(par2World, (EntityPlayer)par7EntityLivingBase, true);

		if(res == null)
			return false;
		else if(res.sideHit == -1)
			return false;
		else if(res.sideHit == 0 || res.sideHit == 1)
		{
			double realY;
			if(res.sideHit ==  1)
				realY = -1;
			else
				realY = 1;
			System.out.println("I am here as : " + realY);
			
			for(int i = 0; i < 3; i++)
			{
				if(par2World.getBlockId(x + 1, y+ (int)realY * i, z -1) != Block.bedrock.blockID)
					par2World.destroyBlock(x + 1, y+(int)realY * i, z -1, true);
				if(par2World.getBlockId(x + 1, y+ (int)realY * i, z +1) != Block.bedrock.blockID)
					par2World.destroyBlock(x + 1, y+(int)realY * i, z +1, true);
				if(par2World.getBlockId(x - 1, y+ (int)realY * i, z- 1) != Block.bedrock.blockID)
					par2World.destroyBlock(x - 1, y+(int)realY * i, z -1, true);
				if(par2World.getBlockId(x - 1, y+ (int)realY * i, z + 1) != Block.bedrock.blockID)
					par2World.destroyBlock(x - 1, y+(int)realY * i, z +1, true);
			}
			
			if(par2World.getBlockId(x, y+(int)realY, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+(int)realY, z, true);
			
			if(par2World.getBlockId(x, y+(int)realY*2, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+(int)realY*2, z, true);
			
			if(par2World.getBlockId(x + 1, y, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x + 1, y, z, true);
			
			if(par2World.getBlockId(x - 1, y, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x - 1, y, z, true);
			
			if(par2World.getBlockId(x, y, z + 1) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y, z + 1, true);
			
			if(par2World.getBlockId(x, y, z - 1) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y, z - 1, true);
			
			if(par2World.getBlockId(x + 1, y+(int)realY, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x + 1, y+(int)realY, z, true);
			
			if(par2World.getBlockId(x - 1, y+(int)realY, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x - 1, y+(int)realY, z, true);
			
			if(par2World.getBlockId(x, y+(int)realY, z + 1) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+(int)realY, z + 1, true);
			
			if(par2World.getBlockId(x, y+(int)realY, z - 1) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+(int)realY, z - 1, true);
			
			if(par2World.getBlockId(x + 1, y+(int)realY*2,z) != Block.bedrock.blockID)
				par2World.destroyBlock(x + 1, y+(int)realY*2, z, true);
			
			if(par2World.getBlockId(x - 1, y+(int)realY*2, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x - 1, y+(int)realY*2, z, true);
			
			if(par2World.getBlockId(x, y+(int)realY*2, z + 1) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+(int)realY*2, z + 1, true);
			
			if(par2World.getBlockId(x, y+(int)realY*2, z - 1) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+(int)realY*2, z - 1, true);
		}
		else if(res.sideHit == 4 || res.sideHit == 5)
		{
			System.out.println("Side 4/5");
			double realX;
			if(res.sideHit == 5)
				realX = -1;
			else
				realX = 1;
			if(par2World.getBlockId(x, y + 1, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+ 1, z, true);
			if(par2World.getBlockId(x, y - 1, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y- 1, z, true);
			
			for(int i = 0; i < 3; i++)
			{
				if(par2World.getBlockId(x + (int)realX * i, y + 1, z + 1) != Block.bedrock.blockID)
					par2World.destroyBlock(x + (int)realX * i, y + 1, z + 1, true);
				
				if(par2World.getBlockId(x + (int)realX * i, y + 1, z - 1) != Block.bedrock.blockID)
					par2World.destroyBlock(x + (int)realX * i, y + 1, z - 1, true);
				
				if(par2World.getBlockId(x + (int)realX * i, y - 1, z + 1) != Block.bedrock.blockID)
					par2World.destroyBlock(x + (int)realX * i, y - 1, z + 1, true);
				if(par2World.getBlockId(x + (int)realX * i, y - 1, z - 1) != Block.bedrock.blockID)
					par2World.destroyBlock(x + (int)realX * i, y - 1, z - 1, true);
			}
			
			if(par2World.getBlockId(x + (int)realX, y, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX, y, z, true);
			if(par2World.getBlockId(x + (int)realX*2, y, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX*2, y, z, true);
			if(par2World.getBlockId(x + (int)realX, y+1, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX, y+1, z, true);
			if(par2World.getBlockId(x + (int)realX*2, y+1, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX*2, y+1, z, true);
			if(par2World.getBlockId(x + (int)realX, y-1, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX, y-1, z, true);
			if(par2World.getBlockId(x + (int)realX*2, y-1, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX*2, y-1, z, true);
			if(par2World.getBlockId(x + (int)realX, y, z+1) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX, y, z+1, true);
			if(par2World.getBlockId(x + (int)realX*2, y, z+1) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX*2, y, z+1, true);
			if(par2World.getBlockId(x + (int)realX, y, z-1) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX, y, z-1, true);
			if(par2World.getBlockId(x + (int)realX*2, y, z-1) != Block.bedrock.blockID)
				par2World.destroyBlock(x+(int)realX*2, y, z-1, true);
			if(par2World.getBlockId(x, y, z + 1) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y, z + 1, true);
			if(par2World.getBlockId(x, y, z - 1) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y, z - 1, true);
		}
		else
		{
			System.out.println("Last 3/2");
			double realZ;
			if(res.sideHit == 3)
				realZ = -1;
			else
				realZ = 1;
			
			for(int i = 0; i < 3; i++)
			{
				if(par2World.getBlockId(x + 1, y + 1, z + (int)realZ * i) != Block.bedrock.blockID)
					par2World.destroyBlock(x + 1, y + 1, z + (int)realZ * i, true);
				if(par2World.getBlockId(x - 1, y + 1, z + (int)realZ * i) != Block.bedrock.blockID)
					par2World.destroyBlock(x - 1, y + 1, z + (int)realZ * i, true);
				if(par2World.getBlockId(x + 1, y - 1, z + (int)realZ * i) != Block.bedrock.blockID)
					par2World.destroyBlock(x + 1 , y - 1, z + (int)realZ * i, true);
				if(par2World.getBlockId(x - 1, y - 1, z + (int)realZ * i) != Block.bedrock.blockID)
					par2World.destroyBlock(x - 1, y - 1, z + (int)realZ * i, true);
			}
			
			if(par2World.getBlockId(x, y + 1, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+ 1, z, true);
			if(par2World.getBlockId(x, y - 1, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y- 1, z, true);
			
			if(par2World.getBlockId(x, y, z + (int)realZ) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y, z+(int)realZ, true);
			if(par2World.getBlockId(x, y, z + (int)realZ*2) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y, z+(int)realZ*2, true);
			if(par2World.getBlockId(x, y+1, z + (int)realZ) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+1, z+(int)realZ, true);
			if(par2World.getBlockId(x, y+1, z + (int)realZ*2) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y+1, z+(int)realZ*2, true);
			if(par2World.getBlockId(x, y-1, z + (int)realZ) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y-1, z+(int)realZ, true);
			if(par2World.getBlockId(x, y-1, z + (int)realZ*2) != Block.bedrock.blockID)
				par2World.destroyBlock(x, y-1, z+(int)realZ*2, true);
			
			if(par2World.getBlockId(x + 1, y, z + (int)realZ) != Block.bedrock.blockID)
				par2World.destroyBlock(x+1, y, z+(int)realZ, true);
			if(par2World.getBlockId(x + 1, y, z + (int)realZ*2) != Block.bedrock.blockID)
				par2World.destroyBlock(x+1, y, z+(int)realZ*2, true);
			if(par2World.getBlockId(x -1, y, z + (int)realZ) != Block.bedrock.blockID)
				par2World.destroyBlock(x-1, y, z+(int)realZ, true);
			if(par2World.getBlockId(x-1, y, z + (int)realZ*2) != Block.bedrock.blockID)
				par2World.destroyBlock(x-1, y, z+(int)realZ*2, true);
			if(par2World.getBlockId(x + 1, y, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x + 1, y, z, true);
			if(par2World.getBlockId(x - 1, y, z) != Block.bedrock.blockID)
				par2World.destroyBlock(x - 1, y, z, true);
		}
		}
        return false;
    }

}
