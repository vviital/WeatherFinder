package by.grsu.weather.finder.services;

import by.grsu.weather.finder.model.DayWeather;
import by.grsu.weather.finder.repositories.interfaces.DayWeatherRepository;
import by.grsu.weather.finder.services.interfaces.WeatherFinder;
import by.grsu.weather.finder.services.interfaces.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * Created by vviital on 2.5.16.
 */

@Service("weatherService")
@Transactional
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private WeatherFinder weatherFinder;

    @Autowired
    private DayWeatherRepository repository;

    @Override
    public DayWeather getWeather(Calendar day) {
        List<DayWeather> result = repository.findByDate(day);
        DayWeather weather = new DayWeather();
        if (result.size() == 0) {
            weather = weatherFinder.find(day);
            repository.save(weather);
        } else {
            weather = result.get(0);
        }
        return weather;
    }
}
