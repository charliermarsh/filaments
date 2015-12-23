package com.crmarsh.filaments.utils;


public final class WeatherUtils {
    private WeatherUtils() {
    }

    public static String formatTemperature(final double temperature) {
        return String.format("%.2f ºF", temperature);
    }
}
