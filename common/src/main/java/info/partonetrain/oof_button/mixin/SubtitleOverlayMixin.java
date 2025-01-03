//package info.partonetrain.oof_button.mixin;
//
//import com.llamalad7.mixinextras.sugar.Local;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.components.SubtitleOverlay;
//import net.minecraft.client.multiplayer.ClientLevel;
//import net.minecraft.client.resources.sounds.SoundInstance;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.contents.TranslatableContents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.phys.AABB;
//import net.minecraft.world.phys.Vec3;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.ModifyArg;
//
//import java.util.List;
//
//@Mixin(SubtitleOverlay.class)
//public class SubtitleOverlayMixin {
//    @ModifyArg(method = "onPlaySound", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/SubtitleOverlay$Subtitle;<init>(Lnet/minecraft/network/chat/Component;FLnet/minecraft/world/phys/Vec3;)V", ordinal = 0))
//    public Component oof_button$onPlaySound(Component original, @Local(argsOnly = true) SoundInstance sound){
//        if(original.getContents() instanceof TranslatableContents tc && tc.toString().contains("oof_button.player") && original.getString().contains("$player")){
//            //Constants.LOG.info();
//            String translatedText = original.getString();
//            if(sound.getSource().equals(SoundSource.PLAYERS)){
//                ClientLevel level = Minecraft.getInstance().level;
//                Vec3 start = new Vec3(sound.getX(), sound.getY(), sound.getZ());
//                Vec3 end = new Vec3(sound.getX() + 0.5, sound.getY() + 0.5, sound.getZ() + 0.5);
//                List<Player> playerstAtSound = level.getEntitiesOfClass(Player.class, new AABB(start, end));
//                if(!playerstAtSound.isEmpty()){
//                    String replacedText = original.getString().replace("$player", playerstAtSound.getFirst().getName().getString());
//                    return Component.literal(replacedText);
//                }else{
//                    String replacedText = original.getString().replace("$player", "Someone");
//                    return Component.literal(replacedText);
//                }
//            }
//        }
//        return original;
//    }
//}
