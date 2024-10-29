package xhospital.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;
import xhospital.utils.Utils;

public class ModuleBHOP extends Module {

	public static final String NAME = "BHOP";
	
	private float angle;
	
	public ModuleBHOP() {
		super(NAME);
		this.angle = 0.0f;
	}
	
	@Override
	public void onUpdate(Event e) {
		if (!this.isToggled) return;

		// Minecraft variables
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		World world = mc.theWorld;
		
		Entity nearestEntity = Utils.getNearestEntity();
		double diffX = nearestEntity.posX - player.posX;
		double diffZ = nearestEntity.posZ - player.posZ;
		double diff = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffZ, 2));
		
		if (diff <= 3.0f) {
			if (player.onGround) player.jump();
			player.motionX = Math.sin(Math.toRadians(this.angle)) + diffX / 2;
			player.motionZ = Math.cos(Math.toRadians(this.angle)) + diffZ / 2;
			this.angle = (System.currentTimeMillis() / 5) % 360;
		}
	}
	
}
