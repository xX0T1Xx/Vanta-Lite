package xhospital;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import xhospital.gui.MainGui;
import xhospital.modules.Module;
import xhospital.modules.ModuleAimAssist;
import xhospital.modules.ModuleBHOP;
import xhospital.modules.ModuleESP;
import xhospital.modules.ModuleFlight;
import xhospital.modules.ModuleFullBright;
import xhospital.modules.ModuleKillAura;
import xhospital.modules.ModuleLeftClicker;
import xhospital.modules.ModuleReach;
import xhospital.modules.ModuleScaffold;
import xhospital.modules.ModuleShowMods;
import xhospital.modules.ModuleSprint;
import xhospital.modules.ModuleVelocity;

@Mod(modid = BlackClient.MODID, version = BlackClient.VERSION)
public class BlackClient
{
	// Mod Details
    public static final String MODID = "13704a01e58e0a2ff7bbfa34c7368653"; // MD5: Vanta
    public static final String VERSION = "1.0";
    
    // Client Static Variables
    public static final Events EVENTS = new Events();
    public static final MainGui MAINGUI = new MainGui();
    
    // Client Modules
    public static final Module MODULE_ESP = new ModuleESP();
    public static final Module MODULE_LEFTCLICKER = new ModuleLeftClicker();
    public static final Module MODULE_SCAFFOLD = new ModuleScaffold();
    public static final Module MODULE_AIMASSIST = new ModuleAimAssist();
    public static final Module MODULE_FLIGHT = new ModuleFlight();
    public static final Module MODULE_SPRINT = new ModuleSprint();
    public static final Module MODULE_BHOP = new ModuleBHOP();
    public static final Module MODULE_KILLAURA = new ModuleKillAura();
    public static final Module MODULE_REACH = new ModuleReach();
    public static final Module MODULE_FULLBRIGHT = new ModuleFullBright();
    public static final Module MODULE_SHOWMODS = new ModuleShowMods();
    public static final Module MODULE_VELOCITY = new ModuleVelocity();
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(EVENTS);
    }
}
