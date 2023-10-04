package org.example;
import java.util.Random;

public class PacketGenerator  {
    private Random random;

    public PacketGenerator() {
        random = new Random();
    }
    private GPSposition generateRandomGPSPosition() {
        long id = generateRandomLong();
        double longitude = -180.0 + (360.0 * random.nextDouble());
        double latitude = -90.0 + (180.0 * random.nextDouble());
        return new GPSposition(id, longitude, latitude);
    }
    private byte generateRandomTemperature() {
        float randomTemp = (random.nextInt(81) * 0.5f) - 45.0f;
        return Packet.coder(randomTemp);
    }
    private long generateRandomLong() {
        long randomLong = random.nextLong();
        return randomLong >= 0 ? randomLong : -randomLong;
    }
    public Packet generateRandomPacket() {
        byte sensorTemperature = generateRandomTemperature();
        GPSposition gpsPosition = generateRandomGPSPosition();
        long timeFrame = generateRandomLong();

        Packet packet = new Packet(gpsPosition ,sensorTemperature, timeFrame);
        packet.setCheksum(CheksumEncoderFour.generateCheksum(packet));
        return packet ;
    }
    /*public PacketGenerator(){
        Packet packet = new Packet();
        packet.gps.setId(generateRandomLong());
        packet.gps.setLatitude(generateRandomLatitude());
        packet.gps.setLongitude(generateRandomLongitude());
        packet.setSensorTemperature(coder(generateRandomTemperature()));
        packet.setTimeFrame(generateRandomLong());
        packet.cheksum.setCheksum(generateCheksum(packet));
        PacketToByte.serialize(packet);
        return packet;
    }*/

}
