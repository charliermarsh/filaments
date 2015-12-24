package com.crmarsh.filaments;

import com.crmarsh.filaments.models.WeatherData;
import com.crmarsh.filaments.views.WeatherView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private PresenterComponent mPresenterComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Dagger graph.
        mPresenterComponent = DaggerPresenterComponent
                .builder()
                .presenterModule(new PresenterModule(this))
                .build();

        // Setup views.
        setContentView(R.layout.activity_main);
        ((WeatherView) findViewById(R.id.weather)).updateData(WeatherData.create(50.0123));
    }

    public PresenterComponent getPresenterComponent() {
        return mPresenterComponent;
    }
}
