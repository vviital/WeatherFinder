package by.grsu.weather.finder.services.interfaces;

import by.grsu.weather.finder.model.DayWeather;

import java.util.Calendar;
import java.util.List;

/**
 * Created by vviital on 2.5.16.
 */

public interface WeatherService {
    DayWeather getWeather(Calendar day);

    List<DayWeather> getWeather();
}
