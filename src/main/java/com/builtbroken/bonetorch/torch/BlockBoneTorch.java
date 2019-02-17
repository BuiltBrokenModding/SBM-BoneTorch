package com.builtbroken.bonetorch.torch;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/9/2015.
 */
public class BlockBoneTorch extends BlockTorch
{
    public BlockBoneTorch()
    {
        super(Block.Properties.create(Material.CIRCUITS).doesNotBlockMovement().hardnessAndResistance(0.0F).lightValue(9).sound(SoundType.WOOD));
        this.setRegistryName(BoneTorchMod.PREFIX + "bonetorch");
    }
}
