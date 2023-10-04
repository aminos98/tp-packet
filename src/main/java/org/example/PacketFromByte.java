package org.example;

import java.nio.ByteBuffer;

public class PacketFromByte {
    public static Packet deserialize(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);

        long id = buffer.getLong();
        double latitude = buffer.getDouble();
        double longitude = buffer.getDouble();
        byte sensorTemperature = buffer.get();
        long timeFrame = buffer.getLong();
        int checksum = buffer.getInt();

        GPSposition gpsPosition = new GPSposition();
        gpsPosition.setId(id);
        gpsPosition.setLatitude(latitude);
        gpsPosition.setLongitude(longitude);

        Packet packet = new Packet(gpsPosition, sensorTemperature, timeFrame);
        packet.setCheksum(new CheksumEncoderFour(checksum));

        return packet;
    }
}
