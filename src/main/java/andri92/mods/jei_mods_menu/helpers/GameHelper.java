package andri92.mods.jei_mods_menu.helpers;

import andri92.mods.jei_mods_menu.client.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.creativetab.CreativeTabs;

import static andri92.mods.jei_mods_menu.client.ClientProxy.MINECRAFT;

public class GameHelper {

    private static GameHelper instance;

    public static GameHelper getInstance() {
        if (instance == null) {
            instance = new GameHelper();
        }
        return instance;
    }

    public static GameHelper gameHelper() {
        return GameHelper.getInstance();
    }

    private GameHelper() {
    }

    public Minecraft getMinecraft() {
        return MINECRAFT;
    }

    public boolean hasMultiplePagesOfCreativeTabs() {
        return CreativeTabs.CREATIVE_TAB_ARRAY.length > 12;
    }

}
