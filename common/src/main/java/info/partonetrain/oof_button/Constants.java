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

    public static ResourceLocation getSoundLocation(int index) {
        return getSoundLocation(index, false);
    }
	public static ResourceLocation getSoundLocation(int index, boolean initializing) {
        ResourceLocation ret;
        ret = switch (index) {
            case 0 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "oof");
            case 1 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "roblox_oof");
            case 2 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "vine_boom");
            case 10 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "webfishing_meow");
            case 11 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "webfishing_hiss");
            case 12 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "webfishing_mrrp");
            case 20 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "webfishing_bark");
            case 21 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "webfishing_growl");
            case 22 -> ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "webfishing_whimper");
            default -> ResourceLocation.withDefaultNamespace("entity.player.death");
        };
        if(initializing && ret.getNamespace().equals("minecraft")){
            Constants.LOG.error("Constants::getSoundLocation is missing a sound");
        }

        return ret;
	}
}