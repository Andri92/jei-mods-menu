package andri92.mods.jei_mods_menu.client;

import andri92.mods.jei_mods_menu.JEIModsMenu;
import andri92.mods.jei_mods_menu.core.CommonProxy;
import andri92.mods.jei_mods_menu.managers.EventManager;
import andri92.mods.jei_mods_menu.managers.ModsManager;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
//    public static final String[] GUI_TOP = new String[]{"s", "field_147009_r", "guiTop"};
    public static Minecraft MINECRAFT;

    private static void versionCheck() {
        final NBTTagCompound compound = new NBTTagCompound();
        compound.setString("curseProjectName", "just-enough-buttons");
        compound.setString("curseFilenameParser", "justenoughbuttons-" + ForgeVersion.mcVersion + "-[].jar");
        FMLInterModComms.sendRuntimeMessage(JEIModsMenu.ID, "VersionChecker", "addCurseCheck", compound);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        versionCheck();
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(EventManager.getInstance());
        MINECRAFT = Minecraft.getMinecraft();
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        if (Loader.isModLoaded(JEIModsMenu.DEPENDENCY_JEI_ID)) {
            JEIModsMenu.logInfo("JEI is installed Mod subsets are enabled!");
//            ModSubsetButtonHandler.ENABLE_SUBSETS = true;
            ModsManager.getInstance();
        }
    }

}
