package info.partonetrain.oof_button;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgeSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Constants.MOD_ID);

    public static void init(){
        for (OofSound sound : OofSound.values()) {
            ResourceLocation rl = Constants.getSoundLocation(sound.getIndex());
            Holder<SoundEvent> soundEventHolder = SOUND_EVENTS.register(rl.getPath(), SoundEvent::createVariableRangeEvent);
            CommonSoundEvents.events.put(sound.getIndex(), soundEventHolder);
            Constants.LOG.info("Registered SoundEvent " + soundEventHolder.value().getLocation());
        }
    }
}
