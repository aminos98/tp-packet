package org.example;

public class Packet {
    CheksumEncoderFour cheksum;
    GPSposition gps;
    private byte sensorTemperature ;
    private long timeFrame;
    public Packet(){

    }

    public Packet(GPSposition gps, byte sensorTemperature, long timeFrame) {
        this.gps = gps ;
        this.sensorTemperature = sensorTemperature;
        this.timeFrame = timeFrame;
        this.cheksum = new CheksumEncoderFour();
    }

    public CheksumEncoderFour getCheksum() {
        return cheksum;
    }

    public void setCheksum(CheksumEncoderFour cheksum) {
        this.cheksum = cheksum;
    }

    public byte getSensorTemperature() {
        return sensorTemperature;
    }

    public void setSensorTemperature(byte sensorTemperature) {
        this.sensorTemperature = sensorTemperature;
    }

    public long getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(long timeFrame) {
        this.timeFrame = timeFrame;
    }
    public static byte coder(double temperature) {
        if (temperature < -45.0 || temperature > -5.0) {
            throw new IllegalArgumentException("Temperature out of range: " + temperature);
        }
        double minTemp = -45.0;
        double maxTemp = -5.0;
        byte minByteValue = 0;
        byte maxByteValue = 80;

        double temperatureRange = maxTemp - minTemp;
        double byteValueRange = maxByteValue - minByteValue;

        double scaledValue = (temperature - minTemp) / temperatureRange;
        return (byte)(minByteValue + (scaledValue * byteValueRange));
    }
    public static float decoder (short value) {
        if (value < 0 || value > 80) {
            throw new IllegalArgumentException("Value out of range: " + value);
        }

        short minShortValue = 0;
        short maxShortValue = 80;
        float minTemp = -45.0f;
        float maxTemp = -5.0f;

        float shortValueRange = maxShortValue - minShortValue;
        float temperatureRange = maxTemp - minTemp;

        float scaledValue = (value - minShortValue) / shortValueRange;

        return minTemp + (scaledValue * temperatureRange);
    }

    @Override
    public String toString() {
        String s = "Packet{" +
                " gps = " + gps.toString() +
                ", sensorTemperature = " + decoder(sensorTemperature) + " °C " +
                ", sensorTemperature = " + sensorTemperature + " coder en byte " +
                ", timeFrame = " + timeFrame +
                ", checksum = " + cheksum.toString() +
                '}';
        return s;
    }
}


