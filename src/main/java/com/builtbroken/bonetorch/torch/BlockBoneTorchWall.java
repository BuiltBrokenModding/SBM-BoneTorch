package com.builtbroken.bonetorch.torch;

import com.builtbroken.bonetorch.BoneTorchMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorchWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBoneTorchWall extends BlockTorchWall
{
    public BlockBoneTorchWall()
    {
        super(Block.Properties.create(Material.CIRCUITS).doesNotBlockMovement().hardnessAndResistance(0.0F).lightValue(14).sound(SoundType.WOOD));
        this.setRegistryName(BoneTorchMod.PREFIX + "wall_bonetorch");
    }
}
