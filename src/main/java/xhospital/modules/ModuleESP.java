package xhospital.modules;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import xhospital.utils.Utils;

public class ModuleESP extends Module {

	public static final String NAME = "ESP";
	
	public ModuleESP() {
		super(NAME);
	}
	
	@Override
	public void onRender(Event e) {
		if (!this.isToggled) return;
		
		// Render all living entities' hitbox
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		List<Entity> entities = Minecraft.getMinecraft().theWorld.loadedEntityList;
		float partialTicks = ((RenderWorldLastEvent)e).partialTicks;
		for (Entity entity : entities) {
			if (!(entity instanceof EntityLivingBase)) continue; // ignore non-alive entities
			if (entity.equals(player)) continue; // ignore self
			Utils.renderHitbox(entity, 1.0f, 1.0f, 1.0f, partialTicks);
		}
	}

}
