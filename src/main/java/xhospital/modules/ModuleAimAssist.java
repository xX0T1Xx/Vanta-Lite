package xhospital.modules;

import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import xhospital.utils.Utils;

public class ModuleAimAssist extends Module {

	public static final String NAME = "AimAssist";
	
	public ModuleAimAssist() {
		super(NAME);
	}
	
	@Override
	public void onUpdate(Event e) {
		if (!this.isToggled) return;
		
		// Minecraft variables
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		Entity nearestEntity = Utils.getNearestEntity();
		
		// Distance to entity
		double diffX = (nearestEntity.posX - player.posX) * -1;
		double diffZ = nearestEntity.posZ - player.posZ;
		double diff = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffZ, 2));
		
		// Ideal yaw/pitch to look at entity
		double yaw = Math.toDegrees(Math.atan(diffX / diffZ)) - (diffZ < 0 ? 180 : 0);
		
		// Moving player's camera towards entity
		if (diff <= 4.0D && Mouse.isButtonDown(0) && mc.currentScreen == null) {
			player.rotationYaw = (float)yaw;
		}
	}
	
}
