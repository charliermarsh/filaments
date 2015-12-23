package com.crmarsh.filaments.views;

import static com.crmarsh.filaments.utils.WeatherUtils.formatTemperature;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.crmarsh.filaments.Component;
import com.crmarsh.filaments.R;
import com.crmarsh.filaments.models.WeatherData;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Assumed to be inflated from weather_view.xml.
 */
public class WeatherView extends Component<WeatherData> {
    @Bind(R.id.temperature)
    TextView mTemperatureView;

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this);
    }

    protected void render(final WeatherData weatherData) {
        mTemperatureView.setText(formatTemperature(weatherData.temperature()));
    }
}
