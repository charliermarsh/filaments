package com.crmarsh.filaments.views;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.crmarsh.filaments.BuildConfig;
import com.crmarsh.filaments.MainActivity;
import com.crmarsh.filaments.R;
import com.crmarsh.filaments.models.WeatherData;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Random;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class WeatherViewTest extends TestCase {
    @Test
    public void testRenderWithIdenticalData() {
        final MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        final WeatherView weatherView = (WeatherView) activity.findViewById(R.id.weather);
        final WeatherView weatherViewSpy = spy(weatherView);

        // Create some initial test data.
        final double temperature = 100 * new Random().nextDouble();
        weatherViewSpy.updateData(WeatherData.create(temperature));

        // Update with identical data (as a different object).
        weatherViewSpy.updateData(WeatherData.create(temperature));

        // Verify that `render` was only called once.
        verify(weatherViewSpy).render(any(WeatherData.class));
        verifyNoMoreInteractions(weatherViewSpy);
    }
}
