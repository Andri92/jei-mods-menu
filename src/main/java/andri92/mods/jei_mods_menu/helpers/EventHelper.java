package andri92.mods.jei_mods_menu.helpers;

import net.minecraftforge.fml.common.eventhandler.Event;

public class EventHelper {

    private static EventHelper instance;

    public static EventHelper getInstance() {
        if (instance == null) {
            instance = new EventHelper();
        }
        return instance;
    }

    public static EventHelper eventHelper() {
        return EventHelper.getInstance();
    }

    private EventHelper() {
    }

    public void cancelEvent(Event event) {
        event.setResult(Event.Result.DENY);
        if (event.isCancelable()) {
            event.setCanceled(true);
        }
    }
}
