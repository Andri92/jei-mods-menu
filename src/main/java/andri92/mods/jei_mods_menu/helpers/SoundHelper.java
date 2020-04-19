package andri92.mods.jei_mods_menu.helpers;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;

import static andri92.mods.jei_mods_menu.client.ClientProxy.MINECRAFT;

public class SoundHelper {

    private static SoundHelper instance;

    public static SoundHelper getInstance() {
        if (instance == null) {
            instance = new SoundHelper();
        }
        return instance;
    }

    public static SoundHelper soundHelper() {
        return SoundHelper.getInstance();
    }

    private SoundHelper() {
    }

    public void playClick() {
        MINECRAFT.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0F));
    }

}
