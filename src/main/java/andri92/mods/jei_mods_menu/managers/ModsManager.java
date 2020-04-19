package andri92.mods.jei_mods_menu.managers;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.*;
import java.util.stream.Collectors;

public class ModsManager {

    private static ModsManager instance;

    public static ModsManager getInstance() {
        if (instance == null) {
            instance = new ModsManager();
        }
        return instance;
    }

    public static ModsManager modsManager() {
        return ModsManager.getInstance();
    }

    private List<String> modNames;
    private List<String> modIds;

    private ModsManager() {
        modIds = new ArrayList<>();
        modNames = new ArrayList<>();

        Set<String> modIdsSet = new HashSet<>();

        ForgeRegistries.ITEMS.getKeys().forEach(resource -> {
            String modId = resource.getResourceDomain().toLowerCase();
            if (!modIdsSet.contains(modId)) {
                modIdsSet.add(modId);
                modIds.add(modId);
            }
        });
        ForgeRegistries.BLOCKS.getKeys().forEach(resource -> {
            String modId = resource.getResourceDomain().toLowerCase();
            if (!modIdsSet.contains(modId)) {
                modIdsSet.add(modId);
                modIds.add(modId);
            }
        });

        Map<String, String> idsToNamesMap = Loader.instance().getModList().stream()
                .collect(Collectors.toMap(x -> x.getModId().toLowerCase(), ModContainer::getName));

        modIds.forEach(id -> modNames.add(idsToNamesMap.get(id)));
    }

    public List<String> getModNames() {
        return modNames;
    }

    public List<String> getModIds() {
        return modIds;
    }
}
