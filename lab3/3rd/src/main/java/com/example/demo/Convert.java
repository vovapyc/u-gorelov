package com.example.demo;

import com.example.demo.models.Model;

public class Convert {

    public static String latLonToString(Model model, double northlat, double eastlon, double westlon, double soutlat) {
        String[][] strings = {
                {"1", "2"},
                {"3", "4"}
        };
        int indexLat;
        int indexLon;
        double midlleLon = (eastlon + westlon) / 2;
        double midlleLat = (northlat + soutlat) / 2;
        if (model.getLon() <= midlleLon)
            indexLon = 0;
        else indexLon = 1;

        if (model.getLat() <= midlleLat)
            indexLat = 1;
        else indexLat = 0;
        return strings[indexLat][indexLon];
    }
}
