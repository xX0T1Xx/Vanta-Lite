package xhospital.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;
import xhospital.utils.Timer;
import xhospital.utils.Utils;

public class ModuleKillAura extends Module {

	public static final String NAME = "KillAura";
	
	private Timer timer;
	
	public ModuleKillAura() {
		super(NAME);
		this.timer = new Timer();
	}
	
	@Override
	public void onUpdate(Event e) {
		if (!this.isToggled) return;
		
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		Entity nearestEntity = Utils.getNearestEntity();
		
		if (player.getDistanceToEntity(nearestEntity) <= 3.0F && this.timer.isDone()) {
			player.swingItem();
			mc.playerController.attackEntity(player, nearestEntity);
			timer.sleep(100);
		}
	}
	
}
