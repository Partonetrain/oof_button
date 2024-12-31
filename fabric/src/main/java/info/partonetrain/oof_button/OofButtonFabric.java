package info.partonetrain.oof_button;

import net.fabricmc.api.ModInitializer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.neoforged.fml.config.ModConfig;

public class OofButtonFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        CommonClass.init();
        FabricSoundEvents.init();
        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.COMMON, OofButtonConfig.SPEC, "oof_button-client.toml");
    }
}
