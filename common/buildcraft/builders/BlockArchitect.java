/**
 * Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.builders;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import buildcraft.BuildCraftBuilders;
import buildcraft.core.BlockBuildCraftLED;
import buildcraft.core.GuiIds;

public class BlockArchitect extends BlockBuildCraftLED {
	private IIcon[] led;

	public BlockArchitect() {
		super(Material.iron);
		setRotatable(true);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileArchitect();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7,
			float par8, float par9) {
		if (super.onBlockActivated(world, x, y, z, entityplayer, par6, par7, par8, par9)) {
			return true;
		}

		Item equipped = entityplayer.getCurrentEquippedItem() != null ? entityplayer.getCurrentEquippedItem().getItem() : null;
		if (equipped instanceof ItemConstructionMarker) {
			ItemConstructionMarker.link(entityplayer.getCurrentEquippedItem(), world, x, y, z);

			return true;
		} else {
			if (!world.isRemote) {
				entityplayer.openGui(BuildCraftBuilders.instance, GuiIds.ARCHITECT_TABLE, world, x, y, z);
			}
			return true;
		}
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		return false;
	}

	@Override
	public int getIconGlowLevel(IBlockAccess access, int x, int y, int z) {
		if (renderPass < 1) {
			return -1;
		} else {
			TileArchitect tile = (TileArchitect) access.getTileEntity(x, y, z);
			return tile.getIconGlowLevel(renderPass);
		}
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		return 1;
	}
}
