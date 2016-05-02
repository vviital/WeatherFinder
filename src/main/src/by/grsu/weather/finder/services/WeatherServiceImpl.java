package by.grsu.weather.finder.services;

import by.grsu.weather.finder.model.DayWeather;
import by.grsu.weather.finder.repositories.interfaces.DayWeatherRepository;
import by.grsu.weather.finder.services.interfaces.WeatherFinder;
import by.grsu.weather.finder.services.interfaces.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by vviital on 2.5.16.
 */

@Service("weatherService")
@Repository
@Transactional
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private WeatherFinder weatherFinder;

//    @Autowired
//    private DayWeatherRepository repository;

    @Override
    public DayWeather getWeather(Calendar day) {
     //   System.out.println(repository);
        return weatherFinder.find(day);
    }
}
