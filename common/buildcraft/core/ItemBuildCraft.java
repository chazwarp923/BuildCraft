/**
 * Copyright (c) 2011-2014, SpaceToad and the BuildCraft Team
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.core;

import buildcraft.core.utils.StringUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBuildCraft extends Item {

	private String iconName;
	private boolean passSneakClick = false;

	public ItemBuildCraft() {
		super();
		setCreativeTab(CreativeTabBuildCraft.MACHINES.get());
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemstack) {
		return StringUtils.localize(getUnlocalizedName(itemstack));
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		iconName = par1Str;
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("buildcraft:" + iconName);
	}

	public Item setPassSneakClick(boolean passClick) {
		this.passSneakClick = passClick;
		return this;
	}

	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player) {
		return passSneakClick;
	}
}
