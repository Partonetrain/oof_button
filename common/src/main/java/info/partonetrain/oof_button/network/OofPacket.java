package info.partonetrain.oof_button.network;

import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import info.partonetrain.oof_button.CommonClass;
import info.partonetrain.oof_button.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;

public class OofPacket {

    int oofIndex = 0;
    double oofPitch = 0;
    public static final ResourceLocation CHANNEL = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "oof_packet");
    public static final StreamCodec<FriendlyByteBuf, OofPacket> STREAM_CODEC = StreamCodec.ofMember(OofPacket::encode, OofPacket::decode);

    public OofPacket(int index, double pitch)
    {
        oofIndex = index;
        oofPitch = pitch;
    }

    public static CustomPacketPayload.Type<CustomPacketPayload> type()
    {
        return new CustomPacketPayload.Type<>(CHANNEL);
    }

    public void encode(FriendlyByteBuf buf)
    {
        buf.writeInt(oofIndex);
        buf.writeDouble(oofPitch);
    }

    public static OofPacket decode(FriendlyByteBuf buf)
    {
        return new OofPacket(buf.getInt(0), buf.getDouble(1));
    }

    public static void handle(PacketContext<OofPacket> ctx)
    {

        if (Side.CLIENT.equals(ctx.side()))
        {
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("OofPacket received on the client!: " + ctx.message().oofIndex + " " ));
        }
        else
        {
            ctx.sender().sendSystemMessage(Component.literal("OofPacket received on the server" + ctx.message().oofIndex + " "));
            ctx.sender().level().playSound(ctx.sender(), ctx.sender().getOnPos(), CommonClass.getSoundEvent(ctx.message().oofIndex), SoundSource.PLAYERS, 1F, (float) ctx.message().oofPitch);
        }
    }
}
