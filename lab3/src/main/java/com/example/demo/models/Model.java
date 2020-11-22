package com.example.demo.models;

public class Model {
    private double lat;
    private double lon;

    public Model(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
