package andri92.mods.jei_mods_menu.client.gui.config;

import andri92.mods.jei_mods_menu.JEIModsMenu;
import andri92.mods.jei_mods_menu.core.handlers.ConfigHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class GuiJEBConfig extends GuiConfig {

    private static final List<String> buttonorder = new ArrayList<>();

    public GuiJEBConfig(GuiScreen parentScreen) {
        super(parentScreen, getElements(), JEIModsMenu.ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }

    public static List<IConfigElement> getElements() {
        List<IConfigElement> entries = new ArrayList<>();

        for (String name : ConfigHandler.config.getCategoryNames())
            if (name.equals(ConfigHandler.CATEGORY_CUSTOM))
                entries.add(new ConfigElement(ConfigHandler.config.getCategory(name).setPropertyOrder(buttonorder)));
            else
                entries.add(new ConfigElement(ConfigHandler.config.getCategory(name)));

        return entries;
    }
}
