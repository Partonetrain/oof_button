package info.partonetrain.oof_button.network;

import commonnetwork.api.Network;

public class PacketRegistration {
    public static void init()
    {
        Network.registerPacket(OofPacket.type(), OofPacket.class, OofPacket.STREAM_CODEC, OofPacket::handle);
    }
}
