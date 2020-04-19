package andri92.mods.jei_mods_menu.managers;

import andri92.mods.jei_mods_menu.client.gui.Canvas;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import static andri92.mods.jei_mods_menu.client.gui.StateManager.stateManager;
import static andri92.mods.jei_mods_menu.helpers.GuiHelper.guiHelper;

public class EventManager {

    private static EventManager instance;

    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    private Canvas canvas;

    private EventManager() {
        canvas = new Canvas();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onInitGui(GuiScreenEvent.InitGuiEvent.Pre event) {
        stateManager().setIsModsListVisible(false);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onDrawScreen(GuiScreenEvent.DrawScreenEvent event) {
        canvas.draw(event);

//        if (event.getGui() instanceof GuiConfig) {
//            GuiConfigEntries eL = ((GuiConfig) event.getGui()).entryList;
//            GuiConfig cfg = (GuiConfig) event.getGui();
//            if (cfg.titleLine2 != null && cfg.titleLine2.equals(ConfigHandler.CATEGORY_POSITION)) {
//                int y = getInt(1, eL);
//                int x = getInt(0, eL);
//                GuiUtils.drawGradientRect(10, x, y, x + 75, y + 75, 0x77888888, 0x77888888);
//                ClientProxy.MINECRAFT.fontRenderer.drawString("[Buttons]", x + 14, y + 10, 0xFFFFFF);
//            }
//        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onDrawBackgroundEventPost(GuiScreenEvent.BackgroundDrawnEvent event) {
        if (guiHelper().isGuiContainer(event.getGui())) {
            canvas.draw(event);
        }
//        if (JEIModsMenu.configHasChanged) {
//            JEIModsMenu.configHasChanged = false;
//        }
//
//        if (ConfigHandler.showButtons && event.getGui() != null && event.getGui() instanceof GuiContainer) {
//            int mouseY = JEIModsMenu.commonProxy.getMouseY();
//            int mouseX = JEIModsMenu.commonProxy.getMouseX();
//            GuiContainer g = (GuiContainer) event.getGui();
//
//            if (ModSubsetButtonHandler.ENABLE_SUBSETS && ConfigHandler.enableSubsets)
//                ModSubsetButtonHandler.drawButtons(mouseX, mouseY, ClientProxy.getGuiTop((GuiContainer) event.getGui()));
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
    }

    @SubscribeEvent
    public void handleKeyInputEvent(GuiScreenEvent.KeyboardInputEvent.Post e) {
//        GuiScreen gui = ClientProxy.mc.currentScreen;
//
//        if (gui != null && gui instanceof GuiContainer) {
//            int keyCode = Keyboard.getEventKey();
//
//            if (Keyboard.KEY_ESCAPE == keyCode) {
//                skipModClickCount = 0;
//                skipSaveClickCount = 0;
//            }
//
//            if (ClientProxy.makeCopyKey.isActiveAndMatches(keyCode)) {
//                Slot hovered = ((GuiContainer) gui).getSlotUnderMouse();
//
//                if (hovered != null && ClientProxy.player.inventory.getItemStack().isEmpty() && !hovered.getStack().isEmpty() && hovered.getHasStack()) {
//
//                    ItemStack stack = hovered.getStack().copy();
//                    stack.setCount(1);
//                    NBTTagCompound t = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
//                    t.setBoolean("JEI_Ghost", true);
//                    stack.setTagCompound(t);
//                    ClientProxy.player.inventory.setItemStack(stack);
//                }
//            } else if (ClientProxy.hideAll.isActiveAndMatches(keyCode) && Keyboard.getEventKeyState()) {
//                ConfigHandler.showButtons = !ConfigHandler.showButtons;
//            }
//        }

    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onMouseEvent(GuiScreenEvent.MouseInputEvent event) {
        canvas.handleMouseEvent(event);

//        if (Mouse.getEventButton() == 0) {
//            if (JEIButtons.isAnyButtonHovered && JEIButtons.hoveredButton == EnumButtonCommands.DELETE && !ClientProxy.player.inventory.getItemStack().isEmpty()) {
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

//        }
    }
}
