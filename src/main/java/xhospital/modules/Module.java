package xhospital.modules;

import xhospital.utils.Utils;
import net.minecraftforge.fml.common.eventhandler.Event;

public abstract class Module {

	protected String name;
	protected boolean isToggled;
	
	public Module(String name) {
		this.name = name;
		this.isToggled = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void toggle() {
		this.isToggled = !this.isToggled;
	}
	
	public boolean isToggled() {
		return this.isToggled;
	}
	
	public void onUpdate(Event e){}	
	
	public void onRender(Event e){}
	
	public void onKeyInput(Event e){}
	
	public void onDamage(Event e){}
	
	public void onMouseInput(Event e){}
	
	public void onRenderOverlay(Event e){}
	
	public void onTick(Event e){}
	
}
