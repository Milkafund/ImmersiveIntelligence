package pl.pabilo8.immersiveintelligence.api.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Pabilo8 on 25-01-2020.
 */
public interface ISkycrateMount
{

	double getMountEnergy(ItemStack stack);

	double getMountMaxEnergy(ItemStack stack);

	double getPoweredSpeed(ItemStack stack);

	default double getUnpoweredSpeed(ItemStack stack)
	{
		return 0.05;
	}

	@SideOnly(Side.CLIENT)
	void render(ItemStack stack, World world, float partialTicks, double energy);

	boolean isTesla(ItemStack stack);
}
