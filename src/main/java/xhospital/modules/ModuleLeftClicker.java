package xhospital.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraftforge.fml.common.eventhandler.Event;

import org.lwjgl.input.Mouse;

import xhospital.utils.Timer;
import xhospital.utils.Utils;

public class ModuleLeftClicker extends Module {

	// Constants
	public static final String NAME = "LeftClicker";
	
	// Private variables
	private Timer timer;
	
	public ModuleLeftClicker() {
		super(NAME);
		this.timer = new Timer();
	}

	@Override
	public void onUpdate(Event e) {
		if (!this.isToggled) return;
		
		Minecraft mc = Minecraft.getMinecraft();
		if (Mouse.isButtonDown(0) && mc.currentScreen == null && mc.objectMouseOver.typeOfHit != MovingObjectType.BLOCK && this.timer.isDone()) {
			Utils.clickMouse();
			int spike = Utils.randint(4) == 0 ? 50 : 0;
			this.timer.sleep(25 + Utils.randint(100) + spike);
		}
	}
	
}
