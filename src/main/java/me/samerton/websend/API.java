package me.samerton.websend;

public class API {

    public static void registerCustomPacketHandler(PacketHandler wph) {
        Main.getCommunicationServer().addPacketHandler(wph);
    }
}
