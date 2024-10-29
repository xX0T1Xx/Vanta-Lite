package xhospital.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

import org.lwjgl.input.Mouse;

import xhospital.utils.Utils;

public class ModuleReach extends Module {

	public static final String NAME = "Reach";
	
	private boolean hasClicked;
	
	public ModuleReach() {
		super(NAME);
		this.hasClicked = false;
	}
	
	@Override
	public void onMouseInput(Event e) {
		if (!this.isToggled) return;
		
		if (Mouse.isButtonDown(0) && !this.hasClicked) {
			this.hasClicked = true;

			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.thePlayer;
			World world = mc.theWorld;
			
			Entity entity = Utils.entityRayTrace(100.0f);
			if (entity != null) {
				mc.playerController.attackEntity(mc.thePlayer, entity);
			}
				
		}
		else if (!Mouse.isButtonDown(0)) {
			this.hasClicked = false;
		}
	}
	
}
