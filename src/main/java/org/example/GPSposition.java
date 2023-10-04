package org.example;

public class GPSposition {
    private long id;
    private double longitude;
    private double latitude;

    public GPSposition(long id, double longitude, double latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public GPSposition(){
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "GPSposition{" +
                "id = " + id +
                ", longitude = " + longitude +
                ", latitude = " + latitude +
                '}';
    }
}
