package andri92.mods.jei_mods_menu.helpers;

import andri92.mods.jei_mods_menu.constants.MouseConstants;
import org.lwjgl.input.Mouse;

public class InputHelper {

    private static InputHelper instance;

    public static InputHelper getInstance() {
        if (instance == null) {
            instance = new InputHelper();
        }
        return instance;
    }

    public static InputHelper inputHelper() {
        return InputHelper.getInstance();
    }

    private InputHelper() {
    }

    public boolean wasLeftMouseButtonClicked() {
        return Mouse.getEventButton() == MouseConstants.LEFT_MOUSE_BUTTON && Mouse.getEventButtonState();
    }

    public boolean wasAnyMouseButtonClicked() {
        return Mouse.getEventButton() != -1 && Mouse.getEventButtonState();
    }
}
