package com.crmarsh.filaments;

import static com.google.common.base.Preconditions.checkNotNull;

import com.crmarsh.filaments.presenters.WeatherViewPresenter;
import dagger.Module;
import dagger.Provides;

import android.content.Context;

import javax.inject.Singleton;

@Module
public class PresenterModule {
    private final Context mContext;

    public PresenterModule(final Context context) {
        mContext = checkNotNull(context);
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    WeatherViewPresenter provideWeatherPresenter(final Context context) {
        return new WeatherViewPresenter(context);
    }
}
