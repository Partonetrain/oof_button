package info.partonetrain.oof_button;

import info.partonetrain.oof_button.network.PacketRegistration;
import info.partonetrain.oof_button.platform.Services;
import net.minecraft.sounds.SoundEvent;

public class CommonClass {

    public static void init() {
        PacketRegistration.init();
        if(Services.PLATFORM.isClient()){
            CommonClientClass.init();
        }
    }

    public static SoundEvent getSoundEvent(int index){
        return CommonSoundEvents.events.get(index).value();
    }
}