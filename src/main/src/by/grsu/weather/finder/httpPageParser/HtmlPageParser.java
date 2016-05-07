package by.grsu.weather.finder.httpPageParser;

import by.grsu.weather.finder.model.DayWeather;
import by.grsu.weather.finder.model.Weather;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created by vviital on 1.5.16.
 */
public class HtmlPageParser {
    public static DayWeather parseDayWeather(Element element) {
        DayWeather dayWeather = new DayWeather();
        Elements elements = element.select("tr");
        elements.remove(elements.first());
        elements.remove(elements.first());
        elements.remove(elements.last());
        for(Element currentWeather : elements) {
            dayWeather.addWeather(parseWeather(currentWeather));
        }
        dayWeather.bindWeather();
        return dayWeather;
    }

    private static String getText(List<TextNode> nodes, int index) {
        if (nodes.size() <= index) return "";
        return nodes.get(index).text();
    }

    private static String _getAttribute(Element element) {
        try {
            return element.child(0).child(0).attr("title");
        } catch (Exception e) {
            return "";
        }
    }

    private static Weather parseWeather(Element element) {
        Weather weather = new Weather();
        Elements elements = element.select("td");
        String dayTime = getText(elements.get(0).textNodes(), 0);
        String temperature = elements.get(0).child(1).text();
        String cloudiness = getText(elements.get(1).textNodes(), 1);
        String pressure = getText(elements.get(2).textNodes(), 0);
        String humidity = getText(elements.get(3).textNodes(), 0);
        String windSpeed = getText(elements.get(4).textNodes(), 0);
        String windDirection = _getAttribute(elements.get(5));
        weather.setDayTime(dayTime);
        weather.setTemperature(temperature);
        weather.setCloudiness(cloudiness);
        weather.setPressure(pressure);
        weather.setHumidity(humidity);
        weather.setWindSpeed(windSpeed);
        weather.setWindDirection(windDirection);
        //System.out.println(weather.toString());
        return weather;
    }
}
