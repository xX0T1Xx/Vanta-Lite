package xhospital.utils;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import org.lwjgl.opengl.GL11;

public final class Utils {
	
	// Color Constants
	public static final String GOLD = EnumChatFormatting.GOLD.toString(); 
	public static final String GRAY = EnumChatFormatting.GRAY.toString();
	public static final String DARK_PURPLE = EnumChatFormatting.DARK_PURPLE.toString();
	public static final String DARK_GRAY = EnumChatFormatting.DARK_GRAY.toString();
	public static final String BLUE = EnumChatFormatting.BLUE.toString();
	public static final String YELLOW = EnumChatFormatting.YELLOW.toString();
	public static final String RED = EnumChatFormatting.RED.toString();
	public static final String GREEN = EnumChatFormatting.GREEN.toString();
	public static final String WHITE = EnumChatFormatting.WHITE.toString();
	public static final String BLACK = EnumChatFormatting.BLACK.toString(); 
	public static final String BOLD = EnumChatFormatting.BOLD.toString();
	public static final String RESET = EnumChatFormatting.RESET.toString();
	
	/**
	 * Draws text to the screen with background.
	 */
	public static void drawText(String text, int x, int y, boolean includeBackground) {
		// Creating font object
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
		int textMargin = 5;
		int textHeight = 12;
		// Formatting the new lines
		String splitText[] = text.split("\\n");
		
		// Finding longest string in text
		int maxWidth = 0;
		for (String txt : splitText) {
			if (fontRenderer.getStringWidth(txt) > maxWidth)
				maxWidth = fontRenderer.getStringWidth(txt);
		}
		
		// Drawing background
		if (includeBackground) {
			Gui.drawRect(x - textMargin,
					y - textMargin,
					x + textMargin + maxWidth,
					y + textHeight * splitText.length,
					0x99000000);
		}
		
		// Drawing text
		int lineCounter = 0;
		for (String txt : splitText) {
			fontRenderer.drawStringWithShadow(txt, x, y + textHeight * lineCounter, 0xFFFFFF);
			lineCounter++;
		}
	}
	
	/**
	 * Draws a center string at the given coordinates with the color.
	 */
	public static void drawCenteredString(String text, int x, int y, int color) {
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
		int width = fontRenderer.getStringWidth(text);
		int height = 6;
		fontRenderer.drawString(text, x - (width / 2), y - (height / 2), color);
	}
	
	/**
	 * Adds a message to the chat.
	 */
	public static void sendMessage(String message) {
		Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(message));
	}
	
	/**
	 *  Renders an entity's hitbox
	 */
	public static void renderHitbox(Entity entity, float R, float G, float B, float partialTicks) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		double playerX = player.prevPosX + (player.posX - player.prevPosX) * partialTicks; 
		double playerY = player.prevPosY + (player.posY - player.prevPosY) * partialTicks;
		double playerZ = player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks;
		
		GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glTranslated(-playerX , -playerY, -playerZ);
        GL11.glColor3f(R, G, B);
        GL11.glLineWidth(1.0f);
        RenderGlobal.drawSelectionBoundingBox(entity.getEntityBoundingBox());
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
        
        GL11.glEnable(2929);
        GL11.glDisable(3042);
        GL11.glEnable(3553);
	}
	
	/**
	 * Generates a random integer within the bounds specified
	 */
	public static int randint(int max) {
		return (int)(Math.random() * (max + 1));
	}
	
	/**
	 * Simulates Minecraft's clickMouse function. (Original one is private...)
	 * This method also fires a InputEvent.MouseInputEvent event.
	 */
	public static void clickMouse() {
		MinecraftForge.EVENT_BUS.post(new InputEvent.MouseInputEvent());
		Minecraft mc = Minecraft.getMinecraft();
		mc.thePlayer.swingItem();
		switch (mc.objectMouseOver.typeOfHit) {
			case ENTITY:
				mc.playerController.attackEntity(mc.thePlayer, mc.objectMouseOver.entityHit);
				break;
			case BLOCK:
				BlockPos blockpos = mc.objectMouseOver.getBlockPos();
                if (mc.theWorld.getBlockState(blockpos).getBlock().getMaterial() != Material.air)
                    mc.playerController.clickBlock(blockpos, mc.objectMouseOver.sideHit);
				break;
			default:
				break;
		}
	}
	
	/**
	 * Gets the nearest living entity to the player.
	 */
	public static Entity getNearestEntity() {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		World world = mc.theWorld;
		
		Entity nearestEntity = world.loadedEntityList.get(1);
		for (Entity entity : world.loadedEntityList) {
			if (!(entity instanceof EntityLivingBase)) continue;
			if (entity.equals(player)) continue;
			
			if (player.getDistanceToEntity(entity) < player.getDistanceToEntity(nearestEntity))
				nearestEntity = entity;
		}
		
		return nearestEntity;
	}
	
	/**
	 * Performs a ray trace from the player and returns the first alive Entity it hit.
	 * Note: This function doesn't properly ray trace, it instead checks at intervals.
	 */
	public static Entity entityRayTrace(float reach) {
		
		// Minecraft Variables
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		World world = mc.theWorld;
		
		// Ray variables
		double x = player.posX;
		double y = player.posY + player.eyeHeight;
		double z = player.posZ;
		double delta = 0.1;
		double deltaX = player.getLookVec().xCoord * delta;
		double deltaY = player.getLookVec().yCoord * delta;
		double deltaZ = player.getLookVec().zCoord * delta;
		
		// Performing Trace
		while (player.getPositionEyes(1.0f).distanceTo(new Vec3(x, y, z)) < reach) {
			for (Entity entity : world.getLoadedEntityList()) {
				if (entity.equals(player)) continue;
				if (!(entity instanceof EntityLivingBase)) continue;
				
				if (entity.getEntityBoundingBox().isVecInside(new Vec3(x, y, z)))
					return entity;
			}
			
			x += deltaX;
			y += deltaY;
			z += deltaZ;
		}
		
		return null;
	}
	
	/**
	 * This function draws a chroma string to the screen, color is based on time.
	 */
	public static void drawRainbowString(String text, int x, int y) {
		int R = (int)(Math.sin(Math.toRadians((System.currentTimeMillis() / 10) % 360)) * 127 + 128);
		int G = (int)(Math.sin(Math.toRadians((System.currentTimeMillis() / 10) % 360 + 120)) * 127 + 128);
		int B = (int)(Math.sin(Math.toRadians((System.currentTimeMillis() / 10) % 360 + 240)) * 127 + 128);
		int color = (R << 16) | (G << 8) | B;
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text, x, y, color);
	}
}
