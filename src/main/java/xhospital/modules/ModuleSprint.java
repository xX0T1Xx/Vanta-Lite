package xhospital.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ModuleSprint extends Module {

	public static final String NAME = "Sprint";
	
	public ModuleSprint() {
		super(NAME);
	}
	
	@Override
	public void onUpdate(Event e) {
		if (!this.isToggled) return;
		Minecraft.getMinecraft().thePlayer.setSprinting(true);
	}
	
}
