package andri92.mods.jei_mods_menu.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.client.config.GuiUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.List;

import static andri92.mods.jei_mods_menu.client.gui.StateManager.stateManager;
import static andri92.mods.jei_mods_menu.helpers.EventHelper.eventHelper;
import static andri92.mods.jei_mods_menu.helpers.GuiHelper.guiHelper;
import static andri92.mods.jei_mods_menu.helpers.InputHelper.inputHelper;
import static andri92.mods.jei_mods_menu.helpers.JeiHelper.jeiHelper;

public class ModsList {

    public static final int COLOR_BACKGROUND = 0xCC000000;
    public static final int ITEM_PADDING_TOP = 1;
    public static final int ITEM_PADDING_BOTTOM = 1;
    public static final int ITEM_PADDING_LEFT = 3;
    public static final int ITEM_PADDING_RIGHT = 3;

    public int x0;
    public int x1;
    public int y0;
    public int y1;
    private int pageIndex;
    private int hoveredEntryIndex;
    private List<Entry> entries;

    public ModsList(List<Entry> entries) {
        this.entries = entries;
//        this.entries = new ArrayList<>();
//        for (int i = 0; i < 500; i++) {
//            this.entries.add(new Entry("" + i, i + " " + RandomStringUtils.randomAlphabetic(3, 100)));
//        }
        hoveredEntryIndex = -1;
    }

    public void draw(GuiScreenEvent event) {
        if (!guiHelper().isInSupportedGui(event)) {
            return;
        }
        if (stateManager().isModsListVisible()) {
            setUpRenderingConditions();

            drawBackground();

            FontRenderer fontRenderer = guiHelper().getFontRenderer();

            int itemInnerHeight = fontRenderer.FONT_HEIGHT;
            int itemHeight = itemInnerHeight + ITEM_PADDING_TOP + ITEM_PADDING_BOTTOM;
            int itemWidth = (x1 - x0);
            int itemInnerWidth = itemWidth - ITEM_PADDING_LEFT - ITEM_PADDING_RIGHT;
            int pageSize = (y1 - y0) / itemHeight;
            int numberOfPages = (int) Math.ceil(((double) entries.size()) / pageSize);
            if (pageIndex < 0) {
                pageIndex = 0;
            } else if (pageIndex >= numberOfPages) {
                pageIndex = Math.max(0, numberOfPages - 1);
            }

            hoveredEntryIndex = -1;

            for (int i = 0; i < pageSize; i++) {
                int entriesIndex = i + pageIndex * pageSize;
                if (entriesIndex >= entries.size()) {
                    break;
                }
                String displayName = entries.get(i + pageIndex * pageSize).getDisplayName();
                String trimmedDisplayName = guiHelper().getTextFormatter().trimToWidthWithEllipsis(displayName, itemInnerWidth);

                int itemInnerX0 = x0 + ITEM_PADDING_LEFT;
                int itemInnerX1 = x0 + ITEM_PADDING_LEFT + itemInnerWidth;
                int itemInnerY0 = itemHeight * i + y0 + ITEM_PADDING_TOP;
                int itemInnerY1 = itemHeight * i + y0 + ITEM_PADDING_TOP + itemInnerHeight;

                int textColor = 0xFFFFFF;
                if (hoveredEntryIndex == -1 && guiHelper().isCursorHoveringArea(itemInnerX0, itemInnerX1, itemInnerY0, itemInnerY1)) {
                    hoveredEntryIndex = entriesIndex;
                    textColor = 16777120;
                }

                fontRenderer.drawString(trimmedDisplayName,
                        itemInnerX0,
                        itemInnerY0,
                        textColor);
            }

            tearDownRenderingConditions();
        }
    }

    private void drawBackground() {
        GuiUtils.drawGradientRect(0, x0, y0, x1, y1, COLOR_BACKGROUND, COLOR_BACKGROUND);
    }

    public void handleMouseEvent(GuiScreenEvent.MouseInputEvent event) {
        if (!event.isCanceled() &&
                guiHelper().isInSupportedGui(event) &&
                stateManager().isModsListVisible()) {
            if (isCursorHovering()) {
                if (inputHelper().wasLeftMouseButtonClicked()) {
                    if (hoveredEntryIndex != -1) {
                        jeiHelper().setJeiText("@" + entries.get(hoveredEntryIndex).id);
                        if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                            stateManager().setIsModsListVisible(false);
                        }
                    }
                } else {
                    int deltaScroll = Mouse.getEventDWheel();
                    if (deltaScroll < 0) {
                        pageIndex++;
                    } else if (deltaScroll > 0) {
                        pageIndex--;
                    }
                }
                eventHelper().cancelEvent(event);
            } else {
                if (inputHelper().wasAnyMouseButtonClicked()) {
                    stateManager().setIsModsListVisible(false);
                }
            }
        }
    }

    private boolean isCursorHovering() {
        return guiHelper().isCursorHoveringArea(x0, x1, y0, y1);
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

    public static class Entry {
        private String id;
        private String displayName;

        public Entry(String id, String displayName) {
            this.id = id;
            this.displayName = displayName;
        }

        public String getId() {
            return id;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
