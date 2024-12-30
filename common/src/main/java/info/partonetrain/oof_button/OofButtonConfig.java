package info.partonetrain.oof_button;

import net.minecraft.server.commands.PlaySoundCommand;
import net.neoforged.neoforge.common.ModConfigSpec;

public class OofButtonConfig {
    public static ModConfigSpec.Builder builder;
    public final static ModConfigSpec SPEC;

    public static ModConfigSpec.ConfigValue<OofSound> OOF_SOUND;
    public static ModConfigSpec.ConfigValue<OofSound> OOF_CTRL_SOUND;
    public static ModConfigSpec.ConfigValue<OofSound> OOF_ALT_SOUND;
    public static ModConfigSpec.DoubleValue SOUND_PITCH;

    static {
        builder = new ModConfigSpec.Builder();
        registerConfig(builder);
        SPEC = builder.build();
    }


    public static void registerConfig(ModConfigSpec.Builder builder) {
        OOF_SOUND = builder.comment("The sound that happens when you press the Oof Button")
                .define("Oof Sound", OofSound.OOF);
        OOF_CTRL_SOUND = builder.comment("The sound that happens when you press the Oof Button and CTRL")
                .define("Oof Ctrl Sound", OofSound.ROBLOX_OOF);
        OOF_ALT_SOUND = builder.comment("The sound that happens when you press the Oof Button and ALT")
                .define("Oof Alt Sound", OofSound.VINE_BOOM);
        SOUND_PITCH = builder.comment("The pitch wich the sounds your player makes will play at")
                .defineInRange("Pitch", 1, 0.0, 2.0);
    }
}
