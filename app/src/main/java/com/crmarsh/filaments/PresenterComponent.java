package com.crmarsh.filaments;

import com.crmarsh.filaments.views.WeatherView;

import javax.inject.Singleton;

@Singleton
@dagger.Component(modules = {PresenterModule.class})
public interface PresenterComponent {
    void inject(WeatherView weatherView);
}
