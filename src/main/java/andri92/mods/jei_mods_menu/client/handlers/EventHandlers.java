package andri92.mods.jei_mods_menu.client.handlers;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class EventHandlers {

    static int skipSaveClickCount = 0;
    static int skipModClickCount = 0;
    private static BlockPos lastPlayerPos = null;
    private boolean isLMBDown = false;
    private boolean isRMBDown = false;
    private boolean drawMobOverlay = false;



//    private static int getInt(int i, GuiConfigEntries eL) {
//        if (i < eL.getSize() && eL.getListEntry(i) != null && String.valueOf(eL.getListEntry(i).getCurrentValue()).length() > 0 && String.valueOf(eL.getListEntry(i).getCurrentValue()).length() < 5
//                && !String.valueOf(eL.getListEntry(i).getCurrentValue()).equals("-"))
//            return Integer.parseInt(String.valueOf(eL.getListEntry(i).getCurrentValue()));
//        return -1;
//    }

//    @SubscribeEvent(priority = EventPriority.LOWEST)
//    public void onDrawScreen(GuiScreenEvent.DrawScreenEvent e) {
//        if (e.getGui() != null && e.getGui() instanceof GuiContainer) {
//            int mouseY = JEIModsMenu.commonProxy.getMouseY();
//            int mouseX = JEIModsMenu.commonProxy.getMouseX();
//
//            if (ConfigHandler.enableSubsets)
//                Canvas.draw(mouseX, mouseY);
//        }
//
//        if (e.getGui() instanceof GuiConfig) {
//            GuiConfigEntries eL = ((GuiConfig) e.getGui()).entryList;
//            GuiConfig cfg = (GuiConfig) e.getGui();
//            if (cfg.titleLine2 != null && cfg.titleLine2.equals(ConfigHandler.CATEGORY_POSITION)) {
//                int y = getInt(1, eL);
//                int x = getInt(0, eL);
//                GuiUtils.drawGradientRect(10, x, y, x + 75, y + 75, 0x77888888, 0x77888888);
//                ClientProxy.MINECRAFT.fontRenderer.drawString("[Buttons]", x + 14, y + 10, 0xFFFFFF);
//            }
//        }
////        if (ConfigHandler.showButtons && e.getGui() != null && e.getGui() instanceof GuiContainer) {
////            int mouseY = JEIModsMenu.commonProxy.getMouseY();
////            int mouseX = JEIModsMenu.commonProxy.getMouseX();
////
////            if (ConfigHandler.enableSubsets)
////                ModSubsetButtonHandler.drawSubsetList(mouseX, mouseY);
////        }
////
////        if (e.getGui() instanceof GuiConfig) {
////            GuiConfigEntries eL = ((GuiConfig) e.getGui()).entryList;
////            GuiConfig cfg = (GuiConfig) e.getGui();
////            if (cfg.titleLine2 != null && cfg.titleLine2.equals(ConfigHandler.CATEGORY_POSITION)) {
////                int y = getInt(1, eL);
////                int x = getInt(0, eL);
////                GuiUtils.drawGradientRect(10, x, y, x + 75, y + 75, 0x77888888, 0x77888888);
////                ClientProxy.MINECRAFT.fontRenderer.drawString("[Buttons]", x + 14, y + 10, 0xFFFFFF);
////            }
////        }
//    }

//    @SubscribeEvent(priority = EventPriority.LOWEST)
//    public void onDrawBackgroundEventPost(GuiScreenEvent.BackgroundDrawnEvent e) {
//        if (JEIModsMenu.configHasChanged) {
//            JEIModsMenu.configHasChanged = false;
//        }
//
//        if (ConfigHandler.showButtons && e.getGui() != null && e.getGui() instanceof GuiContainer) {
//            int mouseY = JEIModsMenu.commonProxy.getMouseY();
//            int mouseX = JEIModsMenu.commonProxy.getMouseX();
//            GuiContainer g = (GuiContainer) e.getGui();
//
//            if (ModSubsetButtonHandler.ENABLE_SUBSETS && ConfigHandler.enableSubsets)
//                ModSubsetButtonHandler.drawButtons(mouseX, mouseY, ClientProxy.getGuiTop((GuiContainer) e.getGui()));
//
//            if (Mouse.isButtonDown(0) && !isLMBDown) {
//                isLMBDown = true;
//
//                ModSubsetButtonHandler.click(mouseX, mouseY);
//            } else if (!Mouse.isButtonDown(0)) {
//                isLMBDown = false;
//            }
//
//            if (Mouse.isButtonDown(1) && !isRMBDown) {
//                isRMBDown = true;
//            } else if (!Mouse.isButtonDown(1))
//                isRMBDown = false;
//        }
//    }

    @SubscribeEvent
    public void handleKeyInputEvent(GuiScreenEvent.KeyboardInputEvent.Post e) {
//        GuiScreen gui = ClientProxy.MINECRAFT.currentScreen;
//
//        if (gui != null && gui instanceof GuiContainer) {
//            int keyCode = Keyboard.getEventKey();
//
//            if (Keyboard.KEY_ESCAPE == keyCode) {
//                skipModClickCount = 0;
//                skipSaveClickCount = 0;
//            }
//        }

    }

    @SubscribeEvent
    public void onMouseEvent(GuiScreenEvent.MouseInputEvent event) {
//        if (Mouse.getEventButton() == 0) {
//            if (JEIModsMenu.isAnyButtonHovered && JEIModsMenu.hoveredButton == EnumButtonCommands.DELETE && !ClientProxy.player.inventory.getItemStack().isEmpty()) {
//                event.setResult(Event.Result.DENY);
//                if (event.isCancelable())
//                    event.setCanceled(true);
//            }
//
//            if (skipSaveClickCount > 0) {
//                if (event.isCancelable())
//                    event.setCanceled(true);
//                event.setResult(Event.Result.DENY);
//                skipSaveClickCount--;
//            }
//
//            if (skipModClickCount > 0) {
//                if (event.isCancelable())
//                    event.setCanceled(true);
//                event.setResult(Event.Result.DENY);
//                skipModClickCount--;
//            }
//        }
//
//        if (Mouse.getDWheel() != 0 && ModSubsetButtonHandler.isListShown) {
//            ModSubsetButtonHandler.scroll(Mouse.getEventDWheel());
//        }
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
//        if (enableOverlays) {
//            int kC = Keyboard.getEventKey();
//
//            if (Keyboard.getEventKeyState()) {
//                if (ClientProxy.mobOverlay.isActiveAndMatches(kC)) {
//                    drawMobOverlay = !drawMobOverlay;
//                    if (!drawMobOverlay) {
//                        MobOverlayRenderer.clearCache();
//                        lastPlayerPos = null;
//                    }
//                }
//
//                if (ClientProxy.chunkOverlay.isActiveAndMatches(kC)) {
//                    ClientProxy.mc.debugRenderer.toggleChunkBorders();
//                }
//            }
//
//        }
    }

}
