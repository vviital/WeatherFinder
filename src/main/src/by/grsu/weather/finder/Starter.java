package by.grsu.weather.finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by vviital on 1.5.16.
 */
@SpringBootApplication
@ComponentScan
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
//        WeatherFinderImpl finder = new WeatherFinderImpl();
//        Calendar day = new GregorianCalendar(2013, 8, 1);
//        for(int i = 0; i < 200; ++i) {
//            finder.find(day);
//            day.add(Calendar.DAY_OF_YEAR, 1);
//        }
    }
}
