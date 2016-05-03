package by.grsu.weather.finder.services;

import by.grsu.weather.finder.httpPageParser.HttpPageSearcher;
import by.grsu.weather.finder.model.DayWeather;
import by.grsu.weather.finder.model.Weather;
import by.grsu.weather.finder.services.interfaces.WeatherFinder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by vviital on 1.5.16.
 */
@Service("weatherFinder")
@Transactional
public class WeatherFinderImpl implements WeatherFinder{
    public WeatherFinderImpl() {

    }

    public DayWeather find(Calendar date) {
        DayWeather dayWeather = new DayWeather();
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH) + 1;
        int year = date.get(Calendar.YEAR);
        String url = "http://meteo.by/grodno/retro/" + year + "-" + month + "-" + day;
        dayWeather = HttpPageSearcher.find(url);
        dayWeather.setDate(date);
        if (dayWeather.getEvening() == null) {
            int num = 0;
            num++;
        }
        return dayWeather;
    }
}
