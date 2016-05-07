package by.grsu.weather.finder.repositories.interfaces;

import by.grsu.weather.finder.model.DayWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

/**
 * Created by vviital on 2.5.16.
 */

@Repository
public interface DayWeatherRepository extends CrudRepository<DayWeather, Long> {

    List<DayWeather> findByDate(Calendar day);
}
