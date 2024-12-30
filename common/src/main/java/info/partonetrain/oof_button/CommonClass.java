package info.partonetrain.oof_button;

import com.mojang.blaze3d.platform.InputConstants;
import info.partonetrain.oof_button.network.PacketRegistration;
import info.partonetrain.oof_button.platform.Services;
import net.minecraft.client.KeyMapping;
import net.minecraft.sounds.SoundEvent;
import org.lwjgl.glfw.GLFW;

public class CommonClass {

    public static final KeyMapping OOF_BUTTON = new KeyMapping(
            "key.oof_button.oof",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.misc");

    public static void init() {
        PacketRegistration.init();
        if(Services.PLATFORM.isClient()){
            CommonClientClass.init();
        }
    }

    public static SoundEvent getSoundEvent(int index){
        return SoundEvent.createFixedRangeEvent(Constants.getSoundLocation(index), 8);
    }
}