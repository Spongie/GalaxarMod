package Galaxar.Mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import Galaxar.Mod.Blocks.*;
import Galaxar.Mod.GUI.GuiHandler;
import Galaxar.Mod.Items.*;
import Galaxar.Mod.TileEntitys.TileEntityGalaxarChest;
import Galaxar.Mod.TileEntitys.TileEntityWorldMiner;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="Galaxar", name="Galaxar Mod", version="0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class MainMod {

	public static CreativeTabs galaxarCreativeTab = new CreativeTabs("Galaxar") {
        public ItemStack getIconItemStack() {
                return new ItemStack(darkPlankFrame, 1);
        }
};

	@Instance("Galaxar")
	public static MainMod instance;
	
	public final static Block darkPlanks = new DarkPlanks(3430, Material.wood);
	public final static Block darkPlankFrame = new DarkPlankFrame(3432, Material.wood);
	
	public final static Block galaxarChest = new GalaxarChest(3438, Material.iron);
	
	public final static Block greenGlass = new GreenGlass(3444);
	public final static Block blackGlass = new BlackGlass(3445);
	public final static Block blueGlass = new BlueGlass(3446);
	public final static Block redGlass = new RedGlass(3447);
	
	public final static Block worldMiner = new WorldMiner(3448, Material.iron);
	
	public final static Item darkStick = new DarkStick(3431);
	public final static Item dyeBucket = new DyeBucket(3439);
	public final static Item blueDyeBucket = new BlueDyeBucket(3440);
	public final static Item greenDyeBucket = new GreenDyeBucket(3441);
	public final static Item redDyeBucket = new RedDyeBucket(3442);
	public final static Item blackDyeBucket = new BlackDyeBucket(3443);
	
	public static EnumToolMaterial darkPlankToolMaterial = EnumHelper.addToolMaterial("Dark Plank", 2, 250, 4.5f, 0.0f, 0);
	public static EnumToolMaterial fabianSwordMaterial = EnumHelper.addToolMaterial("Fabian", 4, 5000, 30, 10, 30);
	
	public final static Item darkPlankPickAxe = new DarkPlankPickAxe(3433, darkPlankToolMaterial);
	public final static Item darkPlankAxe = new DarkPlankAxe(3434, darkPlankToolMaterial);
	public final static Item darkPlankShovel = new DarkPlankShovel(3435, darkPlankToolMaterial);
	public final static Item darkPlankSword = new DarkPlankSword(3436, darkPlankToolMaterial);
	public final static Item darkPlankHoe = new DarkPlankHoe(3437, darkPlankToolMaterial);
	public final static Item fabianSword = new FabianSword(3449, fabianSwordMaterial);
	
	@SidedProxy(clientSide="Galaxar.Mod.Client.ClientProxy", serverSide="Galaxar.Mod.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//what here!?
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
		
		new GuiHandler();
		
		RegisterBlocks();
		RegisterItems();
		RegisterRecepies();
		RegisterTools();
		RegisterEntities();
	}
	
	private void RegisterEntities()
	{
		GameRegistry.registerTileEntity(TileEntityGalaxarChest.class, "galaxarChest");
		GameRegistry.registerTileEntity(TileEntityWorldMiner.class, "worldMiner");
	}
	
	private void RegisterBlocks()
	{
		GameRegistry.registerBlock(darkPlanks, "darkPlanks");
		LanguageRegistry.addName(darkPlanks, "Dark Planks");
		MinecraftForge.setBlockHarvestLevel(darkPlanks, "axe", 1);
		
		GameRegistry.registerBlock(darkPlankFrame, "darkPlankFrame");
		LanguageRegistry.addName(darkPlankFrame, "Dark Plank Frame");
		MinecraftForge.setBlockHarvestLevel(darkPlankFrame, "axe", 3);
		
		GameRegistry.registerBlock(galaxarChest, "galaxarChest");
		LanguageRegistry.addName(galaxarChest, "Galaxar Chest");
		
		GameRegistry.registerBlock(blackGlass, "blackGlass");
		LanguageRegistry.addName(blackGlass, "Black Glass");
		
		GameRegistry.registerBlock(blueGlass, "blueGlass");
		LanguageRegistry.addName(blueGlass, "Blue Glass");
		
		GameRegistry.registerBlock(greenGlass, "greenGlass");
		LanguageRegistry.addName(greenGlass, "Green Glass");
		
		GameRegistry.registerBlock(redGlass, "redGlass");
		LanguageRegistry.addName(redGlass, "Red Glass");
		
		GameRegistry.registerBlock(worldMiner, "worldMiner");
		LanguageRegistry.addName(worldMiner, "World Miner");
	}
	
	private void RegisterItems()
	{
		GameRegistry.registerItem(fabianSword, "fabianSword");
		LanguageRegistry.addName(fabianSword, "Sword of Fabian");
		
		GameRegistry.registerItem(darkStick, "darkStick");
		LanguageRegistry.addName(darkStick, "Dark Stick");
		
		GameRegistry.registerItem(dyeBucket, "dyeBucket");
		LanguageRegistry.addName(dyeBucket, "Bucket of Dye");
		
		GameRegistry.registerItem(blueDyeBucket, "blueDyeBucket");
		LanguageRegistry.addName(blueDyeBucket, "Bucket of Blue Dye");
		
		GameRegistry.registerItem(greenDyeBucket, "greenDyeBucket");
		LanguageRegistry.addName(greenDyeBucket, "Bucket of Green Dye");
		
		GameRegistry.registerItem(redDyeBucket, "redDyeBucket");
		LanguageRegistry.addName(redDyeBucket, "Bucket of Red Dye");
		
		GameRegistry.registerItem(blackDyeBucket, "blacDyeBucket");
		LanguageRegistry.addName(blackDyeBucket, "Bucket of Black Dye");
	}
	
	private void RegisterRecepies()
	{
		GameRegistry.addRecipe(new ItemStack(darkPlankFrame), new Object[]{"WWW","SGS","WWW", 'W', darkPlanks, 'G', Block.glass, 'S', darkStick});
		GameRegistry.addRecipe(new ItemStack(darkStick, 4), new Object[]{"W","W", 'W', darkPlanks});
		GameRegistry.addRecipe(new ItemStack(darkPlanks), new Object[]{"C","W","I", 'C', Item.coal , 'W', Block.planks, 'I', Item.dyePowder});
	
		GameRegistry.addRecipe(new ItemStack(dyeBucket, 1), new Object[]{"DDD", " B ", 'D', Item.dyePowder, 'B', Item.bucketEmpty});
		GameRegistry.addShapelessRecipe(new ItemStack(blueDyeBucket,1), new Object[]{new ItemStack(Item.bucketEmpty, 1), new ItemStack(Item.dyePowder, 1, 4)});
		GameRegistry.addShapelessRecipe(new ItemStack(greenDyeBucket,1), new Object[]{new ItemStack(Item.bucketEmpty, 1), new ItemStack(Item.dyePowder, 1, 2)});
		GameRegistry.addShapelessRecipe(new ItemStack(redDyeBucket,1), new Object[]{new ItemStack(Item.bucketEmpty, 1), new ItemStack(Item.dyePowder, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(blackDyeBucket,1), new Object[]{new ItemStack(Item.bucketEmpty, 1), new ItemStack(Item.dyePowder, 1)});
	
		GameRegistry.addRecipe(new ItemStack(galaxarChest, 1), new Object[]{"FDF","DDD","FDF", 'F', darkPlankFrame, 'D', darkPlanks});
		
		GameRegistry.addShapelessRecipe(new ItemStack(blueGlass, 1), new Object[]{new ItemStack(Block.glass, 1), new ItemStack(blueDyeBucket, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapelessRecipe(new ItemStack(greenGlass, 1), new Object[]{new ItemStack(Block.glass, 1), new ItemStack(greenDyeBucket, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapelessRecipe(new ItemStack(redGlass, 1), new Object[]{new ItemStack(Block.glass, 1), new ItemStack(redDyeBucket, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapelessRecipe(new ItemStack(blackGlass, 1), new Object[]{new ItemStack(Block.glass, 1), new ItemStack(blackDyeBucket, 1, OreDictionary.WILDCARD_VALUE)});
	
	
	}
	
	private void RegisterTools()
	{
		GameRegistry.registerItem(darkPlankAxe, "darkPlankAxe");
		LanguageRegistry.addName(darkPlankAxe, "Dark Plank Axe");
		
		GameRegistry.registerItem(darkPlankPickAxe, "darkPlankPickAxe");
		LanguageRegistry.addName(darkPlankPickAxe, "Dark Plank PickAxe");
		
		GameRegistry.registerItem(darkPlankShovel, "darkPlankShovel");
		LanguageRegistry.addName(darkPlankShovel, "Dark Plank Shovel");
		
		GameRegistry.registerItem(darkPlankHoe, "darkPlankHoe");
		LanguageRegistry.addName(darkPlankHoe, "Dark Plank Hoe");
		
		GameRegistry.registerItem(darkPlankSword, "darkPlankSword");
		LanguageRegistry.addName(darkPlankSword, "Dark Plank Sword");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	
}
