package by.grsu.weather.finder.httpPageParser;

import by.grsu.weather.finder.model.DayWeather;
import by.grsu.weather.finder.model.Weather;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by vviital on 1.5.16.
 */
public class HttpPageParser {
    public static DayWeather parseDayWeather(Element element) {
        DayWeather dayWeather = new DayWeather();
        Elements elements = element.select("tr");
        elements.remove(elements.first());
        elements.remove(elements.first());
        elements.remove(elements.last());
        dayWeather.setNight(parseWeather(elements.get(0)));
        dayWeather.setMorning(parseWeather(elements.get(1)));
        dayWeather.setDay(parseWeather(elements.get(2)));
        dayWeather.setEvening(parseWeather(elements.get(3)));
        return dayWeather;
    }

    private static Weather parseWeather(Element element) {
        Weather weather = new Weather();
        Elements elements = element.select("td");
        String temperature = elements.get(0).child(1).text();
        String cloudiness = elements.get(1).textNodes().get(1).text();
        String pressure = elements.get(2).textNodes().get(0).text();
        String humidity = elements.get(3).textNodes().get(0).text();
        String windSpeed = elements.get(4).textNodes().get(0).text();
        String windDirection = elements.get(5).child(0).child(0).attr("title");
        weather.setTemperature(temperature);
        weather.setCloudiness(cloudiness);
        weather.setPressure(pressure);
        weather.setHumidity(humidity);
        weather.setWindSpeed(windSpeed);
        weather.setWindDirection(windDirection);
        System.out.println(weather.toString());
        return weather;
    }
}
