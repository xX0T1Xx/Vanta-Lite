package xhospital.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.Event;
import xhospital.BlackClient;
import xhospital.utils.Utils;

public class ModuleShowMods extends Module {

	public static final String NAME = "ShowMods";
	
	public ModuleShowMods() {
		super(NAME);
		this.isToggled = true;
	}
	
	@Override
	public void onRenderOverlay(Event e) {
		if (!this.isToggled) return;
		
		if (Minecraft.getMinecraft().currentScreen != null) return;
		
		String string = "";
		string += BlackClient.MODULE_AIMASSIST.isToggled()   ? BlackClient.MODULE_AIMASSIST.getName()   + "\n" : "";
		string += BlackClient.MODULE_BHOP.isToggled()        ? BlackClient.MODULE_BHOP.getName()        + "\n" : "";
		string += BlackClient.MODULE_ESP.isToggled()         ? BlackClient.MODULE_ESP.getName()         + "\n" : "";
		string += BlackClient.MODULE_FLIGHT.isToggled()      ? BlackClient.MODULE_FLIGHT.getName()      + "\n" : "";
		string += BlackClient.MODULE_FULLBRIGHT.isToggled()  ? BlackClient.MODULE_FULLBRIGHT.getName()  + "\n" : "";
		string += BlackClient.MODULE_KILLAURA.isToggled()    ? BlackClient.MODULE_KILLAURA.getName()    + "\n" : "";
		string += BlackClient.MODULE_LEFTCLICKER.isToggled() ? BlackClient.MODULE_LEFTCLICKER.getName() + "\n" : "";
		string += BlackClient.MODULE_REACH.isToggled()       ? BlackClient.MODULE_REACH.getName()       + "\n" : "";
		string += BlackClient.MODULE_SCAFFOLD.isToggled()    ? BlackClient.MODULE_SCAFFOLD.getName()    + "\n" : "";
		string += BlackClient.MODULE_SPRINT.isToggled()      ? BlackClient.MODULE_SPRINT.getName()      + "\n" : "";
		string += BlackClient.MODULE_VELOCITY.isToggled()    ? BlackClient.MODULE_VELOCITY.getName()    + "\n" : "";
		
		int x = 5;
		int y = 5;
		for (String str : string.split("\n")) {
			Utils.drawRainbowString(str, x, y);
			y += 12;
		}
		
	}
	
}
