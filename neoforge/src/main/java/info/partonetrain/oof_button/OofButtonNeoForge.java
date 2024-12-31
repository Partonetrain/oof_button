package info.partonetrain.oof_button;


import com.mojang.blaze3d.platform.InputConstants;
import commonnetwork.api.Dispatcher;
import info.partonetrain.oof_button.network.OofPacket;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
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

    public OofButtonNeoForge(ModContainer container, IEventBus eventBus) {
        CommonClass.init();
        container.registerConfig(ModConfig.Type.COMMON, OofButtonConfig.SPEC, "oof_button-client.toml");
        NeoForgeSoundEvents.init();
        NeoForgeSoundEvents.SOUND_EVENTS.register(eventBus);
    }
}