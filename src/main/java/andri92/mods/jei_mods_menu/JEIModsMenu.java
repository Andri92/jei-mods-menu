package andri92.mods.jei_mods_menu;

import andri92.mods.jei_mods_menu.core.CommonProxy;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

@Mod(
        modid = JEIModsMenu.ID,
        version = JEIModsMenu.VERSION,
        acceptedMinecraftVersions = JEIModsMenu.ACCEPTED_MINECRAFT_VERSIONS,
        guiFactory = JEIModsMenu.GUI_FACTORY_CLASSPATH,
        clientSideOnly = JEIModsMenu.IS_CLIENT_SIDE_ONLY,
        dependencies = JEIModsMenu.DEPENDENCIES
)
public class JEIModsMenu {

    public static final String ID = "jei_mods_menu";
    public static final String VERSION = "1.12-0.1.0";
    public static final String GUI_FACTORY_CLASSPATH = "andri92.mods.jei_mods_menu.client.gui.config.GuiFactory";
    public static final boolean IS_CLIENT_SIDE_ONLY = true;
    public static final String ACCEPTED_MINECRAFT_VERSIONS = "1.12.2";
    public static final String DEPENDENCY_JEI_ID = "jei";
    public static final String DEPENDENCIES = "required-after:" + DEPENDENCY_JEI_ID;

    @Mod.Instance
    public static JEIModsMenu instance;

    @SidedProxy(clientSide = "andri92.mods.jei_mods_menu.client.ClientProxy", serverSide = "andri92.mods.jei_mods_menu.core.CommonProxy")
    public static CommonProxy commonProxy;

    public static boolean configHasChanged = false;

    public static void logInfo(String s, Object... format) {
        FMLLog.log("justenoughbuttons", Level.INFO, s, format);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        commonProxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        commonProxy.init(event);
//        commonProxy.registerKeyBind();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        commonProxy.postInit(event);
    }

}
