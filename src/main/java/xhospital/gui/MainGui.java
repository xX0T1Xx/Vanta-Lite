package xhospital.gui;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.GuiScreen;
import xhospital.BlackClient;
import xhospital.modules.Module;
import xhospital.utils.Utils;

public class MainGui extends GuiScreen {
	
	// Watermark
	private RainbowString watermark;
	
	// Cheat Dropdowns
	private GuiDropdown dropdown1;
	private GuiDropdown dropdown2;
	private GuiDropdown dropdown3;
	
	@Override
	public void initGui() {
		
		this.watermark = new RainbowString("Vanta Lite", 10, 10);
		
		this.dropdown1 = new GuiDropdown("combat", 10, 30);
		this.dropdown1.addGuiOption(new GuiOption(BlackClient.MODULE_AIMASSIST, 0, 0));
		this.dropdown1.addGuiOption(new GuiOption(BlackClient.MODULE_KILLAURA, 0, 0));
		this.dropdown1.addGuiOption(new GuiOption(BlackClient.MODULE_LEFTCLICKER, 0, 0));
		this.dropdown1.addGuiOption(new GuiOption(BlackClient.MODULE_REACH, 0, 0));
		
		this.dropdown2 = new GuiDropdown("render", 130, 30);
		this.dropdown2.addGuiOption(new GuiOption(BlackClient.MODULE_ESP, 0, 0));
		this.dropdown2.addGuiOption(new GuiOption(BlackClient.MODULE_FULLBRIGHT, 0, 0));
		this.dropdown2.addGuiOption(new GuiOption(BlackClient.MODULE_SHOWMODS, 0, 0));
		
		this.dropdown3 = new GuiDropdown("movement", 250, 30);
		this.dropdown3.addGuiOption(new GuiOption(BlackClient.MODULE_BHOP, 0, 0));
		this.dropdown3.addGuiOption(new GuiOption(BlackClient.MODULE_FLIGHT, 0, 0));
		this.dropdown3.addGuiOption(new GuiOption(BlackClient.MODULE_SCAFFOLD, 0, 0));
		this.dropdown3.addGuiOption(new GuiOption(BlackClient.MODULE_SPRINT, 0, 0));
		this.dropdown3.addGuiOption(new GuiOption(BlackClient.MODULE_VELOCITY, 0, 0));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.watermark.draw();
		this.dropdown1.draw();
		this.dropdown2.draw();
		this.dropdown3.draw();
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		this.dropdown1.click(mouseX, mouseY);
		this.dropdown2.click(mouseX, mouseY);
		this.dropdown3.click(mouseX, mouseY);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
}
