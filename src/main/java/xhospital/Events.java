package xhospital;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import org.lwjgl.input.Keyboard;

public class Events {
	
	@SubscribeEvent
	public void onFrame(RenderGameOverlayEvent event) {
		BlackClient.MODULE_ESP.onUpdate(event);
		BlackClient.MODULE_LEFTCLICKER.onUpdate(event);
		BlackClient.MODULE_SCAFFOLD.onUpdate(event);
		BlackClient.MODULE_AIMASSIST.onUpdate(event);
		BlackClient.MODULE_FLIGHT.onUpdate(event);
		BlackClient.MODULE_SPRINT.onUpdate(event);
		BlackClient.MODULE_BHOP.onUpdate(event);
		BlackClient.MODULE_KILLAURA.onUpdate(event);
		BlackClient.MODULE_REACH.onUpdate(event);
		BlackClient.MODULE_FULLBRIGHT.onUpdate(event);
		BlackClient.MODULE_SHOWMODS.onUpdate(event);
		BlackClient.MODULE_VELOCITY.onUpdate(event);
	}
	
	@SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
		BlackClient.MODULE_ESP.onRender(event);
		BlackClient.MODULE_LEFTCLICKER.onRender(event);
		BlackClient.MODULE_SCAFFOLD.onRender(event);
		BlackClient.MODULE_AIMASSIST.onRender(event);
		BlackClient.MODULE_FLIGHT.onRender(event);
		BlackClient.MODULE_SPRINT.onRender(event);
		BlackClient.MODULE_BHOP.onRender(event);
		BlackClient.MODULE_KILLAURA.onRender(event);
		BlackClient.MODULE_REACH.onRender(event);
		BlackClient.MODULE_FULLBRIGHT.onRender(event);
		BlackClient.MODULE_SHOWMODS.onRender(event);
		BlackClient.MODULE_VELOCITY.onRender(event);
	}	
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		BlackClient.MODULE_ESP.onKeyInput(event);
		BlackClient.MODULE_LEFTCLICKER.onKeyInput(event);
		BlackClient.MODULE_SCAFFOLD.onKeyInput(event);
		BlackClient.MODULE_AIMASSIST.onKeyInput(event);
		BlackClient.MODULE_FLIGHT.onKeyInput(event);
		BlackClient.MODULE_SPRINT.onKeyInput(event);
		BlackClient.MODULE_BHOP.onKeyInput(event);
		BlackClient.MODULE_KILLAURA.onKeyInput(event);
		BlackClient.MODULE_REACH.onKeyInput(event);
		BlackClient.MODULE_FULLBRIGHT.onKeyInput(event);
		BlackClient.MODULE_SHOWMODS.onKeyInput(event);
		BlackClient.MODULE_VELOCITY.onKeyInput(event);
		
		// Menu hotkey
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
			Minecraft.getMinecraft().displayGuiScreen(BlackClient.MAINGUI);
	}
	
	@SubscribeEvent
	public void onLivingHurtEvent(LivingHurtEvent event) {
		BlackClient.MODULE_ESP.onDamage(event);
		BlackClient.MODULE_LEFTCLICKER.onDamage(event);
		BlackClient.MODULE_SCAFFOLD.onDamage(event);
		BlackClient.MODULE_AIMASSIST.onDamage(event);
		BlackClient.MODULE_FLIGHT.onDamage(event);
		BlackClient.MODULE_SPRINT.onDamage(event);
		BlackClient.MODULE_BHOP.onDamage(event);
		BlackClient.MODULE_KILLAURA.onDamage(event);
		BlackClient.MODULE_REACH.onDamage(event);
		BlackClient.MODULE_FULLBRIGHT.onDamage(event);
		BlackClient.MODULE_SHOWMODS.onDamage(event);
		BlackClient.MODULE_VELOCITY.onDamage(event);
	}
	
	@SubscribeEvent
	public void onMouseInput(InputEvent.MouseInputEvent event) {
		BlackClient.MODULE_ESP.onMouseInput(event);
		BlackClient.MODULE_LEFTCLICKER.onMouseInput(event);
		BlackClient.MODULE_SCAFFOLD.onMouseInput(event);
		BlackClient.MODULE_AIMASSIST.onMouseInput(event);
		BlackClient.MODULE_FLIGHT.onMouseInput(event);
		BlackClient.MODULE_SPRINT.onMouseInput(event);
		BlackClient.MODULE_BHOP.onMouseInput(event);
		BlackClient.MODULE_KILLAURA.onMouseInput(event);
		BlackClient.MODULE_REACH.onMouseInput(event);
		BlackClient.MODULE_FULLBRIGHT.onMouseInput(event);
		BlackClient.MODULE_SHOWMODS.onMouseInput(event);
		BlackClient.MODULE_VELOCITY.onMouseInput(event);
	}
	
	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
		BlackClient.MODULE_ESP.onRenderOverlay(event);
		BlackClient.MODULE_LEFTCLICKER.onRenderOverlay(event);
		BlackClient.MODULE_SCAFFOLD.onRenderOverlay(event);
		BlackClient.MODULE_AIMASSIST.onRenderOverlay(event);
		BlackClient.MODULE_FLIGHT.onRenderOverlay(event);
		BlackClient.MODULE_SPRINT.onRenderOverlay(event);
		BlackClient.MODULE_BHOP.onRenderOverlay(event);
		BlackClient.MODULE_KILLAURA.onRenderOverlay(event);
		BlackClient.MODULE_REACH.onRenderOverlay(event);
		BlackClient.MODULE_FULLBRIGHT.onRenderOverlay(event);
		BlackClient.MODULE_SHOWMODS.onRenderOverlay(event);
		BlackClient.MODULE_VELOCITY.onRenderOverlay(event);
	}
	
	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if (event.phase == TickEvent.Phase.START) {
			BlackClient.MODULE_ESP.onTick(event);
			BlackClient.MODULE_LEFTCLICKER.onTick(event);
			BlackClient.MODULE_SCAFFOLD.onTick(event);
			BlackClient.MODULE_AIMASSIST.onTick(event);
			BlackClient.MODULE_FLIGHT.onTick(event);
			BlackClient.MODULE_SPRINT.onTick(event);
			BlackClient.MODULE_BHOP.onTick(event);
			BlackClient.MODULE_KILLAURA.onTick(event);
			BlackClient.MODULE_REACH.onTick(event);
			BlackClient.MODULE_FULLBRIGHT.onTick(event);
			BlackClient.MODULE_SHOWMODS.onTick(event);
			BlackClient.MODULE_VELOCITY.onTick(event);
		}
	}
	
}
