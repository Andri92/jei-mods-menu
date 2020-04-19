package andri92.mods.jei_mods_menu.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import static andri92.mods.jei_mods_menu.client.gui.StateManager.stateManager;
import static andri92.mods.jei_mods_menu.helpers.EventHelper.eventHelper;
import static andri92.mods.jei_mods_menu.helpers.GameHelper.gameHelper;
import static andri92.mods.jei_mods_menu.helpers.GuiHelper.guiHelper;
import static andri92.mods.jei_mods_menu.helpers.InputHelper.inputHelper;

public class ModsButton {
    //    public static final String BUTTON_LABEL = I18n.format(Localization.MODS);
    public static final String BUTTON_LABEL = "Mods";

    public static int MODS_BUTTON_WIDTH = 150;
    public static int MODS_BUTTON_HEIGHT = 20;
    public static int MODS_BUTTON_Y = 1;

    public final GuiButton modsButton;

    public ModsButton() {
        modsButton = new GuiButton(0, 0, MODS_BUTTON_Y, MODS_BUTTON_WIDTH, MODS_BUTTON_HEIGHT, BUTTON_LABEL);
    }

    public void draw(GuiScreenEvent event) {
        GuiScreen guiScreen = event.getGui();
        if (!guiHelper().isSupportedGui(guiScreen)) {
            return;
        }
        if (guiHelper().getScreenWidth() <= MODS_BUTTON_WIDTH) {
            return;
        }
        int guiY0;
        if (guiHelper().isGuiContainer(guiScreen)) {
            guiY0 = guiHelper().asGuiContainer(guiScreen).getGuiTop();
            if (guiHelper().isGuiContainerCreative(guiScreen) && gameHelper().hasMultiplePagesOfCreativeTabs()) {
                guiY0 -= 50;
            }
        } else {
            try {
                guiY0 = ObfuscationReflectionHelper.getPrivateValue((Class<? super GuiScreen>) guiScreen.getClass(), guiScreen, "guiTop");
            } catch (RuntimeException e) {
                return;
            }
        }
        if (guiY0 < MODS_BUTTON_Y + MODS_BUTTON_HEIGHT + 1) {
            return;
        }

        setUpRenderingConditions();
        modsButton.x = guiHelper().getScreenWidth() / 2 - MODS_BUTTON_WIDTH / 2;
        modsButton.drawButton(gameHelper().getMinecraft(), guiHelper().getMouseX(), guiHelper().getMouseY(), 0);
        tearDownRenderingConditions();
    }

    public void handleMouseEvent(GuiScreenEvent.MouseInputEvent event) {
        if (!event.isCanceled() &&
                guiHelper().isInSupportedGui(event) &&
                inputHelper().wasLeftMouseButtonClicked() &&
                modsButton.mousePressed(gameHelper().getMinecraft(), guiHelper().getMouseX(), guiHelper().getMouseY())) {
            stateManager().toggleIsModsListVisible();
            eventHelper().cancelEvent(event);
        }
    }

    private void setUpRenderingConditions() {
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableDepth();
    }

    private void tearDownRenderingConditions() {
        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
    }
}
