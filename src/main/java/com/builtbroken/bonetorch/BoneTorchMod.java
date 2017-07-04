package com.builtbroken.bonetorch;

import com.builtbroken.bonetorch.torch.BlockBoneTorch;
import com.builtbroken.bonetorch.torch.ItemBlockBoneTorch;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Simple mod to add a bone torch to MC. Idea was spawned from running out of
 * torches in the nether. Where the play may still be able to get coal and bones
 * from wither skeletons.
 * Created by Dark on 7/25/2015.
 */
@Mod(modid = BoneTorchMod.DOMAIN, name = "Bone Torch Mod", version = "@MAJOR@.@MINOR@.@REVIS@.@BUILD@")
@Mod.EventBusSubscriber()
public class BoneTorchMod
{
    public static final String DOMAIN = "bonetorch";
    public static final String PREFIX = DOMAIN + ":";

    public static BlockBoneTorch blockTorch;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new ItemBlockBoneTorch(blockTorch).setRegistryName(blockTorch.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(blockTorch = new BlockBoneTorch());
    }

    @SubscribeEvent
    public static void registerAllModels(ModelRegistryEvent event)
    {
        blockTorch.registerModel();
    }

    @Mod.EventHandler
    public void postInit(RegistryEvent.Register<IRecipe> event)
    {
        event.getRegistry().register(new ShapedOreRecipe(
                new ResourceLocation(DOMAIN, blockTorch.getRegistryName() + ".0"),
                new ItemStack(blockTorch, 4, 0),
                "c",
                "s",
                'c', Items.COAL,
                's', Items.BONE));

        event.getRegistry().register(new ShapedOreRecipe(
                new ResourceLocation(DOMAIN, blockTorch.getRegistryName() + ".1"),
                new ItemStack(blockTorch, 4, 0),
                "c",
                "s",
                'c', new ItemStack(Items.COAL, 1, 1),
                's', Items.BONE));
    }
}
