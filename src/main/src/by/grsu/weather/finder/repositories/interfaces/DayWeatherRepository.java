package by.grsu.weather.finder.repositories.interfaces;

import by.grsu.weather.finder.model.DayWeather;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vviital on 2.5.16.
 */
public interface DayWeatherRepository extends CrudRepository<DayWeather, Long> {

}
