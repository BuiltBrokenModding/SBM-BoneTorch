package com.builtbroken.bonetorch.torch;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockBoneTorch extends ItemBlock
{
    public ItemBlockBoneTorch(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int meta)
    {
        return meta;
    }
}