package xhospital.gui;

import net.minecraft.client.Minecraft;

/**
 * This class defines a rainbow string on the screen.
 * Each time it is drawn it will iterate through the rainbow based on the current time.
 */
public class RainbowString {

	private String text;
	private int x;
	private int y;
	
	public RainbowString(String text, int x, int y) {
		this.text = text;
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		int R = (int)(Math.sin(Math.toRadians((System.currentTimeMillis() / 10) % 360)) * 127 + 128);
		int G = (int)(Math.sin(Math.toRadians((System.currentTimeMillis() / 10) % 360 + 120)) * 127 + 128);
		int B = (int)(Math.sin(Math.toRadians((System.currentTimeMillis() / 10) % 360 + 240)) * 127 + 128);
		int color = (R << 16) | (G << 8) | B;
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.text, this.x, this.y, color);
	}
}
