package xhospital.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ModuleFlight extends Module {

	public static final String NAME = "Flight";
	
	public ModuleFlight() {
		super(NAME);
	}
	
	@Override
	public void onUpdate(Event e) {
		if (!this.isToggled) return;
		Minecraft.getMinecraft().thePlayer.capabilities.allowFlying = true;
	}
}
