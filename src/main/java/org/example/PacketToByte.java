package org.example;

import java.nio.ByteBuffer;

public class PacketToByte {
    public PacketToByte() {

    }

    public static byte[] serialize(Packet p) {
        byte[] a = new byte[37];
        ByteBuffer buffer = ByteBuffer.wrap(a);

        buffer.putLong(p.gps.getId());

        buffer.putDouble(p.gps.getLatitude());

        buffer.putDouble(p.gps.getLongitude());

        buffer.put(p.getSensorTemperature());

        buffer.putLong(p.getTimeFrame());

        buffer.putInt(p.cheksum.getCheksum1());

        return a;
    }
}
