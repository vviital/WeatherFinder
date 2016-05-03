package by.grsu.weather.finder.wrappers;

import by.grsu.weather.finder.model.DayWeather;

/**
 * Created by vviital on 3.5.16.
 */
public class WeatherWrapper {
    private DayWeather weather;

    public WeatherWrapper(DayWeather weather) {
        setWeather(weather);
    }

    public DayWeather getWeather() {
        return weather;
    }

    public void setWeather(DayWeather weather) {
        this.weather = weather;
    }
}
