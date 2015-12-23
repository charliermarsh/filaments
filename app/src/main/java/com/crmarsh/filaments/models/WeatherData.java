package com.crmarsh.filaments.models;

import com.crmarsh.filaments.ComponentData;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class WeatherData implements ComponentData {
    public abstract double temperature();

    public static WeatherData create(final double temperature) {
        return new AutoValue_WeatherData(temperature);
    }
}
