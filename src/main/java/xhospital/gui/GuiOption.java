package xhospital.gui;

import net.minecraft.client.gui.Gui;
import xhospital.modules.Module;
import xhospital.utils.Utils;

/**
 * This class defines a custom option to be selected on the menu.
 * GuiOptions have a fixed width of 100 x 20 pixels
 */
public class GuiOption {

	// Dimensions
	public static final int WIDTH = 100;
	public static final int HEIGHT = 20;
	
	// Private Variables
	private Module module;
	private int x;
	private int y;
	
	public GuiOption(Module module, int x, int y) {
		this.module = module;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Toggles the module associated with the GuiOption.
	 */
	public void toggle() {
		this.module.toggle();
	}
	
	/**
	 * Draws the GuiOption to the screen.
	 */
	public void draw() {
		Gui.drawRect(this.x, this.y, this.x + WIDTH, this.y + HEIGHT, 0x99000000);
		Utils.drawCenteredString(this.module.getName(), this.x + (WIDTH / 2), this.y + (HEIGHT / 2), this.module.isToggled() ? 0x00FF00 : 0xFF0000);
	}
	
	/**
	 * Checks if the mouse is over the GuiOption.
	 */
	public boolean isMouseOver(int mouseX, int mouseY) {
		if (mouseX >= this.x && mouseX <= this.x + WIDTH && mouseY >= this.y && mouseY <= this.y + HEIGHT)
			return true;
		else
			return false;
	}
	
	/**
	 * Moves the GuiOption to the given x, y coordinate.
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
