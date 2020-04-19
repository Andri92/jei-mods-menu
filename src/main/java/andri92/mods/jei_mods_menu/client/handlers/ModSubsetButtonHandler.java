package andri92.mods.jei_mods_menu.client.handlers;

public class ModSubsetButtonHandler {
//    private static final int ITEM_HEIGHT = 11;
//    public static boolean ENABLE_SUBSETS = false;
//    static boolean isListShown = false;
//    private static GuiButton subsetButton = new GuiButton(0, 0, 2, 150, 20, I18n.format(Localization.MODS));
//    private static List<String> modNames; // Contains of all mod_names which add blocks/items
//    private static List<String> modIds; // Contains of all mod_names which add blocks/items
//    private static int scrollOffset = 0;
//    private static int selectedItem = -1;
//    private static String longestModName;
//
//    static void drawButtons(int mouseX, int mouseY, int guiTop) {
//        if (CreativeTabs.CREATIVE_TAB_ARRAY.length > 12 && guiTop < 72 && ClientProxy.MINECRAFT.currentScreen instanceof GuiContainerCreative) {
//            subsetButton.setWidth(45);
//            subsetButton.y = guiTop - 50;
//            subsetButton.x = JEIModsMenu.commonProxy.getScreenWidth() / 2 - 74;
//
//            if (guiTop > 21)
//                subsetButton.drawButton(ClientProxy.MINECRAFT, mouseX, mouseY, 0);
//        } else {
//            subsetButton.setWidth(150);
//            subsetButton.y = 2;
//            subsetButton.x = JEIModsMenu.commonProxy.getScreenWidth() / 2 - 75;
//
//            if (guiTop > 21)
//                subsetButton.drawButton(ClientProxy.MINECRAFT, mouseX, mouseY, 0);
//        }
//    }
//
//    static void drawSubsetList(int mouseX, int mouseY) {
//        boolean anyButtonHovered = false;
//
//        if (isListShown) {
//
//            FontRenderer f = ClientProxy.MINECRAFT.fontRenderer;
//
//            int maxItems = (JEIModsMenu.commonProxy.getScreenHeight() - (22 + subsetButton.y)) / ITEM_HEIGHT - 1;
//            int maximumIndex = Math.min(maxItems + scrollOffset, modNames.size());
//
//            if (scrollOffset > modNames.size() - maxItems)
//                scrollOffset = modNames.size() - maximumIndex;
//
//            String mod;
//            int x, y = (20 + subsetButton.y), w, h;
//            int itemsLeft = modIds.size() - scrollOffset - maxItems;
//
//            RenderHelper.enableGUIStandardItemLighting();
//            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
//            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
//            GlStateManager.disableDepth();
//
//            w = f.getStringWidth(longestModName) + 3;
//            x = subsetButton.x;
//            h = f.FONT_HEIGHT + 2;
//            GuiUtils.drawGradientRect(0, x, y, x + w, y + 3 + h * ((maxItems < modIds.size() ? maxItems : modIds.size()) + (itemsLeft > 0 ? 1 : 0)), 0xCC000000, 0xCC000000);
//            for (int i = scrollOffset; i < maximumIndex; i++) {
//                mod = modNames.get(i);
//                y = (23 + subsetButton.y) + h * (i - scrollOffset);
//
//                if (mouseX >= x && mouseX <= x + w && mouseY > y && mouseY < y + h) {
//                    f.drawString(mod, x + 2, y + 1, 16777120);
//                    selectedItem = i;
//                    anyButtonHovered = true;
//                } else {
//                    f.drawString(mod, x + 2, y + 1, 0xFFFFFF);
//                }
//            }
//
//            if (modIds.size() > maxItems && itemsLeft > 0)
//                f.drawString(itemsLeft + " " + I18n.format(Localization.MORE) + "...", x + 2, y + h + 1, 0xFFFFFF);
//
//            GlStateManager.enableDepth();
//            GlStateManager.enableLighting();
//            RenderHelper.enableStandardItemLighting();
//            GlStateManager.enableRescaleNormal();
//            RenderHelper.disableStandardItemLighting();
//        }
//
//        if (!anyButtonHovered) {
//            selectedItem = -1;
//        }
//    }
//
//    static void click(int mouseX, int mouseY) {
//        boolean flag = false;
//
//        if (subsetButton.mousePressed(ClientProxy.MINECRAFT, mouseX, mouseY)) {
//            JEIModsMenu.commonProxy.playClick();
//            isListShown = !isListShown;
//            flag = true;
//            if (!isListShown)
//                EventHandlers.skipModClickCount = 0;
//        }
//
//        if (selectedItem > -1 && selectedItem < modNames.size()) {
//            JEIModsMenu.commonProxy.playClick();
//            isListShown = !isListShown;
//            JEIPlugin.setJEIText("@" + modIds.get(selectedItem));
//            flag = true;
//            EventHandlers.skipModClickCount = 2;
//        }
//
//        if (!flag && isListShown)
//            isListShown = false;
//    }
//
//    static void scroll(int i) {
//        if (i < 0) {
//            int maxItems = (JEIModsMenu.commonProxy.getScreenHeight() - (22 + subsetButton.y)) / ITEM_HEIGHT - 1;
//            if (scrollOffset + 1 <= modNames.size() - maxItems)
//                scrollOffset++;
//        } else if (i > 0) {
//            if (scrollOffset - 1 >= 0)
//                scrollOffset--;
//        }
//    }
}
