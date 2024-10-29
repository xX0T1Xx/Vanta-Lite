package xhospital.modules;

import net.minecraft.client.Minecraft;

public class ModuleFullBright extends Module {

	public static final String NAME = "FullBright";
	
	public ModuleFullBright() {
		super(NAME);
	}
	
	@Override
	public void toggle() {
		this.isToggled = !this.isToggled;
		Minecraft.getMinecraft().gameSettings.gammaSetting = (this.isToggled ? 2000.0f : 1.0f);
	}
}
