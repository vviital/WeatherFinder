package by.grsu.weather.finder.wrappers;

import by.grsu.weather.finder.model.DayWeather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vviital on 3.5.16.
 */
public class ListWeatherWrapper {
    private List<DayWeather> weathers = new ArrayList<DayWeather>();

    public ListWeatherWrapper(List<DayWeather> weathers) {
        setWeathers(weathers);
    }

    public List<DayWeather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<DayWeather> weathers) {
        this.weathers = weathers;
    }
}
