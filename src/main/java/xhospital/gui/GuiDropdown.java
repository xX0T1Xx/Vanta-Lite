package xhospital.gui;

import java.util.ArrayList;

import xhospital.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

/**
 * This class defines a dropdown menu of GuiOption's.
 * The title of it is fixed at 100 x 20 pixels
 * This element can be dragged around.
 */
public class GuiDropdown {

	// Constants
	private static final int WIDTH = 100;
	private static final int HEIGHT = 20;
	
	// Private Variables
	private String title;
	private int x;
	private int y;
	private boolean isOpen;
	private ArrayList<GuiOption> guiOptions;
	
	public GuiDropdown(String title, int x, int y) {
		this.title = title;
		this.x = x;
		this.y = y;
		this.isOpen = true;
		this.guiOptions = new ArrayList<GuiOption>();
	}
	
	/**
	 * Adds a GuiOption to the dropdown.
	 */
	public void addGuiOption(GuiOption guiOption) {
		this.guiOptions.add(guiOption);
	}
	
	/**
	 * Draws the GuiDropdown to the screen.
	 */
	public void draw() {
		
		// Drawing title
		Gui.drawRect(this.x, this.y, this.x + WIDTH, this.y + HEIGHT, 0xFF000000);
		Utils.drawCenteredString(this.title + (this.isOpen ? " [-]": " [+]"), this.x + (WIDTH / 2), this.y + (HEIGHT / 2), 0xFFFFFF);
		
		// Drawing GuiOptions
		if (!this.isOpen) return;
		int currentX = this.x;
		int currentY = this.y + HEIGHT;
		for (GuiOption guiOption : this.guiOptions) {
			guiOption.move(currentX, currentY);
			guiOption.draw();
			currentY += HEIGHT;
		}
	}
	
	/**
	 * Called when the user clicks anywhere on the Gui.
	 */
	public void click(int mouseX, int mouseY) {
		
		// Mouse Over Label
		if (mouseX >= this.x && mouseX <= this.x + WIDTH && mouseY >= this.y && mouseY <= this.y + HEIGHT) {
			this.isOpen = !this.isOpen;
			return;
		}
		
		// Mouse Over GuiOption
		if (this.isOpen)
			for (GuiOption guiOption : this.guiOptions)
				if (guiOption.isMouseOver(mouseX, mouseY))
					guiOption.toggle();
	}
}














