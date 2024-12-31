package info.partonetrain.oof_button;

import com.mojang.blaze3d.platform.InputConstants;
import commonnetwork.api.Dispatcher;
import info.partonetrain.oof_button.network.OofPacket;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;
import net.neoforged.neoforge.common.NeoForge;
import org.lwjgl.glfw.GLFW;

@Mod(Constants.MOD_ID)
@EventBusSubscriber(value = Dist.CLIENT, modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class OofButtonNeoForgeClient {
    public static final KeyMapping OOF_BUTTON = new KeyMapping(
            "key.oof_button.oof",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.misc");
    public static final KeyMapping OOF_BUTTON_CTRL = new KeyMapping(
            "key.oof_button.oof_ctrl",
            KeyConflictContext.IN_GAME,
            KeyModifier.CONTROL,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.misc");

    public static final KeyMapping OOF_BUTTON_ALT = new KeyMapping(
            "key.oof_button.oof_alt",
            KeyConflictContext.IN_GAME,
            KeyModifier.ALT,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.misc");

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(OOF_BUTTON);
        event.register(OOF_BUTTON_CTRL);
        event.register(OOF_BUTTON_ALT);
    }

    public void onClientTick(ClientTickEvent.Post event) {
        if(Minecraft.getInstance().level != null){
            if(CommonClientClass.cooldown == 0){
                while (OOF_BUTTON.consumeClick()) {
                    Dispatcher.sendToServer(new OofPacket(OofButtonConfig.OOF_SOUND.get().getIndex(), OofButtonConfig.SOUND_PITCH.get()));
                }
            }

            CommonClientClass.cooldown = Math.max(CommonClientClass.cooldown - 1, 0);
            Constants.LOG.info(String.valueOf(CommonClientClass.cooldown));
        }
    }

    public OofButtonNeoForgeClient(){
        NeoForge.EVENT_BUS.addListener(this::onClientTick);
    }

}
