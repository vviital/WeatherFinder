package by.grsu.weather.finder.controllers;

import by.grsu.weather.finder.model.DayWeather;
import by.grsu.weather.finder.services.interfaces.WeatherService;
import by.grsu.weather.finder.wrappers.ListWeatherWrapper;
import by.grsu.weather.finder.wrappers.WeatherWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by vviital on 1.5.16.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/weathers/{date}", method = RequestMethod.GET)
    public WeatherWrapper weather(@PathVariable String date) {
        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]) - 1;
        int day = Integer.parseInt(arr[2]);
        DayWeather dayWeather = new DayWeather();
        try {
            dayWeather = weatherService.getWeather(new GregorianCalendar(year, month, day));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return new WeatherWrapper(dayWeather);
    }

    @RequestMapping(value = "/weathers", method = RequestMethod.GET)
    public ListWeatherWrapper weatherList() {
        List<DayWeather> dayWeathers = weatherService.getWeather();
        return new ListWeatherWrapper(dayWeathers);
    }
}
