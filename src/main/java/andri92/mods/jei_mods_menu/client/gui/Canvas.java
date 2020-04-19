package andri92.mods.jei_mods_menu.client.gui;

import net.minecraftforge.client.event.GuiScreenEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static andri92.mods.jei_mods_menu.helpers.GuiHelper.guiHelper;
import static andri92.mods.jei_mods_menu.managers.ModsManager.modsManager;

public class Canvas {

    private ModsButton modsButton;
    private ModsList modsList;

    public Canvas() {
        modsButton = new ModsButton();

        List<ModsList.Entry> entries = new ArrayList<>();

        for (int i = 0; i < modsManager().getModNames().size(); i++) {
            String id = modsManager().getModIds().get(i);
            String name = modsManager().getModNames().get(i);
            entries.add(new ModsList.Entry(id, name));
        }

        entries.sort(Comparator.comparing(x -> x.getDisplayName().toLowerCase()));

        modsList = new ModsList(entries);
    }

    public void draw(GuiScreenEvent event) {
        if (event instanceof GuiScreenEvent.DrawScreenEvent.Post) {
            modsList.x0 = modsButton.modsButton.x;
            modsList.x1 = modsButton.modsButton.x + modsButton.modsButton.width;
            modsList.y0 = modsButton.modsButton.y + modsButton.modsButton.height;
            modsList.y1 = guiHelper().getScreenHeight() - 30;
            modsList.draw(event);
//        }
//        else if (event instanceof GuiScreenEvent.BackgroundDrawnEvent) {
            modsButton.draw(event);
        }
    }

    public void handleMouseEvent(GuiScreenEvent.MouseInputEvent event) {
        modsButton.handleMouseEvent(event);
        modsList.handleMouseEvent(event);
    }
}
