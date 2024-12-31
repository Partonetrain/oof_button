package info.partonetrain.oof_button;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class FabricSoundEvents {
    public static void init(){
        for (OofSound sound : OofSound.values()) {
            ResourceLocation rl = Constants.getSoundLocation(sound.getIndex());
            SoundEvent se = SoundEvent.createVariableRangeEvent(rl);
            Holder<SoundEvent> soundEventHolder = Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, rl, se);
            CommonSoundEvents.events.put(sound.getIndex(),soundEventHolder);
        }
    }
}
