package xhospital.modules;

import xhospital.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ModuleScaffold extends Module {

	public static final String NAME = "Scaffold";
	
	public ModuleScaffold() {
		super(NAME);
	}
	
	@Override
	public void onUpdate(Event e) {
		if (!this.isToggled) return;
		
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayerSP player = mc.thePlayer;
		WorldClient world = mc.theWorld;
		
		BlockPos blockPos = new BlockPos(player.posX, player.posY, player.posZ).down();
		ItemStack itemStack = player.inventory.getCurrentItem();
		if (world.isAirBlock(blockPos)) {
			player.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(blockPos, EnumFacing.UP.getIndex(), itemStack, 0.5F, 0.5F, 0.5F));
			player.swingItem();
		}
		
	}
	
}
