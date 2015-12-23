package com.crmarsh.filaments.views;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import com.crmarsh.filaments.BuildConfig;
import com.crmarsh.filaments.MainActivity;
import com.crmarsh.filaments.R;
import com.crmarsh.filaments.models.WeatherData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Random;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class WeatherViewTest {
    @Test
    public void testUpdateDataWithSameDataDoesNotRender() {
        final MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        final WeatherView weatherView = (WeatherView) activity.findViewById(R.id.weather);
        final WeatherView weatherViewSpy = spy(weatherView);

        // Seed with initial data.
        final double temperature = 100 * new Random().nextDouble();
        final WeatherData initialWeatherData = WeatherData.create(temperature);
        weatherView.updateData(initialWeatherData);

        // Update with identical data (but a different object).
        final WeatherData nextWeatherData = WeatherData.create(temperature);
        weatherView.updateData(nextWeatherData);

        // Verify that view only rendered once.
        verify(weatherViewSpy).render(initialWeatherData);
    }
}
