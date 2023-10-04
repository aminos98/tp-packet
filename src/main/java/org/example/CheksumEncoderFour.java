package org.example;

public class CheksumEncoderFour {
    private int cheksum;

    public CheksumEncoderFour() {
    }

    public CheksumEncoderFour(int cheksum) {
        this.cheksum = cheksum;
    }

    public int getCheksum1 () {
        return cheksum;
    }

    public void setCheksum1 (int cheksum) {
        this.cheksum = cheksum;
    }

    public static CheksumEncoderFour  generateCheksum (Packet p){

        int la1=(int)(Double.doubleToLongBits(p.gps.getLatitude()));
        int la2=(int)(Double.doubleToLongBits(p.gps.getLatitude())>>32);
        int lon1=(int)(p.gps.getLongitude());
        int lon2=(int)(Double.doubleToLongBits(p.gps.getLongitude())>>32);
        int t1=(int)(Double.doubleToLongBits(p.getTimeFrame()));
        int t2=(int)(Double.doubleToLongBits(p.getTimeFrame())>>32);
        int id1=(int)(Double.doubleToLongBits(p.gps.getId()));
        int id2=(int)(Double.doubleToLongBits(p.gps.getId())>>32);
        int checksumValue = p.getSensorTemperature()+la1+la2+lon1+lon2+t1+t2+id1+id2;
        CheksumEncoderFour checksum = new CheksumEncoderFour();
        checksum.setCheksum1(checksumValue);
        return checksum;

    }

    @Override
    public String toString() {
        return " " + cheksum ;
    }
}
