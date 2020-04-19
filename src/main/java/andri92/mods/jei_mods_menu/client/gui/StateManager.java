package andri92.mods.jei_mods_menu.client.gui;

public class StateManager {

    private static StateManager instance;

    public static StateManager getInstance() {
        if (instance == null) {
            instance = new StateManager();
        }
        return instance;
    }

    public static StateManager stateManager() {
        return StateManager.getInstance();
    }

    private boolean isModsListVisible = false;

    private StateManager() {
    }

    public boolean isModsListVisible() {
        return isModsListVisible;
    }

    public void toggleIsModsListVisible() {
        isModsListVisible = !isModsListVisible;
    }

    public void setIsModsListVisible(boolean isVisible) {
        isModsListVisible = isVisible;
    }
}
