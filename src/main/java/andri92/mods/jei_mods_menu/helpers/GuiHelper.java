package andri92.mods.jei_mods_menu.helpers;

import andri92.mods.jei_mods_menu.client.ClientProxy;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraftforge.client.event.GuiScreenEvent;
import org.lwjgl.input.Mouse;

import static andri92.mods.jei_mods_menu.client.ClientProxy.MINECRAFT;

public class GuiHelper {

    private static GuiHelper instance;

    public static GuiHelper getInstance() {
        if (instance == null) {
            instance = new GuiHelper();
        }
        return instance;
    }

    public static GuiHelper guiHelper() {
        return GuiHelper.getInstance();
    }

    private TextFormatter textFormatter;

    private GuiHelper() {
        textFormatter = new TextFormatter();
    }

    public FontRenderer getFontRenderer() {
        return ClientProxy.MINECRAFT.fontRenderer;
    }

    public int getMouseX() {
        int mX = Mouse.getX() * getScreenWidth() / MINECRAFT.displayWidth;
        return mX + 1;
    }

    public int getMouseY() {
        int scaledHeight = getScreenHeight();
        int mY = scaledHeight - Mouse.getY() * scaledHeight / MINECRAFT.displayHeight - 1;
        return mY;
    }

    public int getScreenWidth() {
        ScaledResolution resolution = new ScaledResolution(MINECRAFT);
        return resolution.getScaledWidth();
    }

    public int getScreenHeight() {
        ScaledResolution resolution = new ScaledResolution(MINECRAFT);
        return resolution.getScaledHeight();
    }

    public boolean isCursorHoveringArea(int x0, int x1, int y0, int y1) {
        int mouseX = getMouseX();
        int mouseY = getMouseY();
        return (x0 <= mouseX && mouseX <= x1 && y0 <= mouseY && mouseY <= y1);
    }

    public boolean isSupportedGui(GuiScreen guiScreen) {
        return isGuiContainer(guiScreen) || isJeiRecipesGui(guiScreen);
    }

    public boolean isGuiContainer(GuiScreen guiScreen) {
        return guiScreen instanceof GuiContainer;
    }

    public boolean isGuiContainerCreative(GuiScreen guiScreen) {
        return guiScreen instanceof GuiContainerCreative;
    }

    public boolean isJeiRecipesGui(GuiScreen guiScreen) {
        return guiScreen.getClass().getSimpleName().equals("RecipesGui");
    }

    public GuiContainer asGuiContainer(GuiScreen guiScreen) {
        return (GuiContainer) guiScreen;
    }

    public boolean isInSupportedGui(GuiScreenEvent e) {
        return isSupportedGui(e.getGui());
    }

    public TextFormatter getTextFormatter() {
        return textFormatter;
    }

    public static class TextFormatter {
        private FontRenderer fontRenderer;
        private Integer ellipsisWidth;

        public String trimToWidthWithEllipsis(String string, int width) {
            fontRenderer = fontRenderer != null ? fontRenderer : guiHelper().getFontRenderer();
            ellipsisWidth = ellipsisWidth != null ? ellipsisWidth : fontRenderer.getStringWidth("...");
            String trimmedDisplayName = fontRenderer.trimStringToWidth(string, width - ellipsisWidth);
            if (string.length() != trimmedDisplayName.length()) {
                trimmedDisplayName = trimmedDisplayName + "...";
            }
            return trimmedDisplayName;
        }
    }
}
