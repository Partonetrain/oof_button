package info.partonetrain.oof_button;

import com.mojang.blaze3d.platform.InputConstants;
import commonnetwork.api.Dispatcher;
import info.partonetrain.oof_button.network.OofPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class OofButtonFabricClient implements ClientModInitializer {
    KeyMapping OOF_BUTTON = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.oof_button.oof",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.misc"));

    KeyMapping CTRL_MOD = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.oof_button.ctrl_modifier",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_CONTROL,
                "key.categories.misc"));

    KeyMapping ALT_MOD = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.oof_button.alt_modifier",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT,
                "key.categories.misc"));
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(Minecraft.getInstance().level != null) {
                if (CommonClientClass.cooldown == 0) {
                    while (OOF_BUTTON.consumeClick()) {
                        int btnIndex = 0;
                        if (CTRL_MOD.isDown()) {
                            btnIndex = OofButtonConfig.OOF_CTRL_SOUND.get().getIndex();
                        }
                        else if (ALT_MOD.isDown()) {
                            btnIndex = OofButtonConfig.OOF_ALT_SOUND.get().getIndex();
                        }
                        else {
                            btnIndex = OofButtonConfig.OOF_SOUND.get().getIndex();
                        }
                        Dispatcher.sendToServer(new OofPacket(btnIndex, OofButtonConfig.SOUND_PITCH.get()));
                        CommonClientClass.cooldown = CommonClientClass.MAX_COOLDOWN;
                    }
                }

                CommonClientClass.cooldown = Math.max(CommonClientClass.cooldown - 1, 0);
            }
        });
    }
}
