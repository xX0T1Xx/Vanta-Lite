package xhospital.modules;

import xhospital.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ModuleVelocity extends Module {

	public static final String NAME = "Velocity";
	
	public ModuleVelocity() {
		super(NAME);
	}
	
	@Override
	public void onTick(Event e) {
		if (!this.isToggled) return;
		
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		
		if (player.hurtResistantTime == 20) {
			player.motionX = 0.0f;
			player.motionY = 0.0f;
			player.motionZ = 0.0f;
		}
	}
}
