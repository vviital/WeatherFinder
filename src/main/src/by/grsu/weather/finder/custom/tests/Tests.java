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
//        Calendar calendar = new GregorianCalendar(2005, 1, 1);
//        for(int i = 0; i < 600; ++i) {
//            try {
//                System.out.println(i + " : " + calendar.toString());
//                DayWeather weather = weatherService.getWeather(calendar);
//                System.out.println(weather.toString());
//                calendar.add(Calendar.DAY_OF_YEAR, 1);
//            } catch (Exception e) {
//                System.out.println(calendar.toString());
//                int num = 0;
//            }
//        }
    }
}
