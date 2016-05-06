package by.grsu.weather.finder.custom.tests;

import by.grsu.weather.finder.model.DayWeather;
import by.grsu.weather.finder.services.interfaces.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by vviital on 2.5.16.
 */
public class Tests {

    @Autowired
    private WeatherService weatherService;

    public void test() {
        Calendar calendar = new GregorianCalendar(2001, 8, 1);
        for (int i = 0; i < 5000; ++i) {
            try {
//                System.out.println(i + " : " + calendar.toString());
                DayWeather weather = weatherService.getWeather(calendar);
                System.out.println(weather.getDay());
            } catch (Exception e) {
                System.out.println(calendar.toString());
            } finally {
                calendar.add(Calendar.DAY_OF_YEAR, 1);
            }
        }
    }
}
