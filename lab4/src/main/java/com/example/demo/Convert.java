package com.example.demo;

import com.example.demo.models.Model;


public class Convert {
    public static String latLonToString(Model geoPoint, double lat, double lon) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");

        double latSize = lat;
        double lonSize = lon;

        double middleLatPoint = 0;
        double middleLonPoint = 0;

        for (int i = 0; i < 30; i++) {
            latSize = latSize / 2;
            lonSize = lonSize / 2;

            if (geoPoint.getLat() >= middleLatPoint) {
                middleLatPoint += latSize;

                if (geoPoint.getLon() >= middleLonPoint) {
                    middleLonPoint += middleLonPoint;
                } else {
                    middleLonPoint -= middleLonPoint;
                }
            } else {
                middleLatPoint -= latSize;
            }


            if (geoPoint.getLon() <= lonSize) {
                sb.append("W");
            } else {
                {
                    sb.append("E");
                }

                if (geoPoint.getLat() <= latSize) {
                    sb.append("S");
                } else {
                    sb.append("N");
                }
            }
        }
        return sb.toString();
    }
}
