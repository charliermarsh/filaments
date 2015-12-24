package com.crmarsh.filaments.views;

import static com.crmarsh.filaments.utils.WeatherUtils.formatTemperature;
import static com.google.common.base.Preconditions.checkNotNull;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.crmarsh.filaments.Component;
import com.crmarsh.filaments.MainActivity;
import com.crmarsh.filaments.R;
import com.crmarsh.filaments.models.WeatherData;
import com.crmarsh.filaments.presenters.WeatherViewPresenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

/**
 * Assumed to be inflated from weather_view.xml.
 */
public class WeatherView extends Component<WeatherData> {
    @Bind(R.id.temperature)
    TextView mTemperatureView;

    @Inject
    WeatherViewPresenter mWeatherViewPresenter;

    public enum INTERACTION_TYPES {
        ON_CLICK
    }

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ((MainActivity) context).getPresenterComponent().inject(this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this);
    }

    protected void render(final WeatherData weatherData) {
        mTemperatureView.setText(formatTemperature(weatherData.temperature()));
        mTemperatureView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mWeatherViewPresenter.onInteract(INTERACTION_TYPES.ON_CLICK, weatherData);
            }
        });
    }
}
