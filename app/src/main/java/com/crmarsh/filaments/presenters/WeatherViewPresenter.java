package com.crmarsh.filaments.presenters;

import static com.crmarsh.filaments.utils.WeatherUtils.formatTemperature;

import com.crmarsh.filaments.ComponentPresenter;
import com.crmarsh.filaments.models.WeatherData;
import com.crmarsh.filaments.views.WeatherView;

import android.content.Context;
import android.widget.Toast;

public class WeatherViewPresenter extends ComponentPresenter<WeatherView.INTERACTION_TYPES, WeatherData> {
    public WeatherViewPresenter(Context context) {
        super(context);
    }

    @Override
    public void onInteract(WeatherView.INTERACTION_TYPES interactionType, WeatherData weatherData) {
        switch (interactionType) {
            case ON_CLICK:
                final CharSequence text = "The temperature is " +
                        formatTemperature(weatherData.temperature()) + ".";
                final int duration = Toast.LENGTH_SHORT;

                Toast.makeText(mContext, text, duration).show();
                return;
        }
        throw new RuntimeException("Invalid interaction type: " + interactionType);
    }
}
