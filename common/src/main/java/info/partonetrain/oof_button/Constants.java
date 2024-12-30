package info.partonetrain.oof_button;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "oof_button";
	public static final String MOD_NAME = "Oof Button";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static final ResourceLocation oofPacket = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "oof_packet");

	public static ResourceLocation getSoundLocation(int index){
        return switch (index) {
            case 0 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "oof");
            case 1 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "roblox_oof");
            case 2 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "vine_boom");
            default -> ResourceLocation.withDefaultNamespace("entity.player.death");
        };
	}
}