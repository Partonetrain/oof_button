package info.partonetrain.oof_button;


import com.mojang.blaze3d.platform.InputConstants;
import commonnetwork.api.Dispatcher;
import info.partonetrain.oof_button.network.OofPacket;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;
import net.neoforged.neoforge.common.NeoForge;
import org.lwjgl.glfw.GLFW;

@Mod(Constants.MOD_ID)
public class OofButtonNeoForge {

    public static final KeyMapping OOF_BUTTON = CommonClass.OOF_BUTTON;
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

    public OofButtonNeoForge(ModContainer container, IEventBus eventBus) {
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

        NeoForge.EVENT_BUS.addListener(this::onClientTick);

        container.registerConfig(ModConfig.Type.COMMON, OofButtonConfig.SPEC, "oof_button-client");
    }

    @SubscribeEvent
    public void registerBindings(RegisterKeyMappingsEvent event) {
        OOF_BUTTON.setKeyConflictContext(KeyConflictContext.IN_GAME);
        event.register(OOF_BUTTON);
        event.register(OOF_BUTTON_CTRL);
        event.register(OOF_BUTTON_ALT);
    }

    @SubscribeEvent
    public void onClientTick(ClientTickEvent.Post event) {
        while (OOF_BUTTON.consumeClick()) {
            Dispatcher.sendToServer(new OofPacket(OofButtonConfig.OOF_SOUND.get().getIndex(), OofButtonConfig.SOUND_PITCH.get()));
        }
    }


}