package by.grsu.weather.finder.httpPageParser;

import by.grsu.weather.finder.model.DayWeather;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by vviital on 1.5.16.
 */
public class HttpPageSearcher {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static DayWeather find(String url) {
        DayWeather weather = new DayWeather();
        try {
            long start = System.currentTimeMillis();
            Document doc = Jsoup.connect(url).get();
            Element element = doc.select("ul.b-weather").first();
            weather = HttpPageParser.parseDayWeather(element);
            long end = System.currentTimeMillis();
            System.out.print(end - start + "\t");
        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
            throw new RuntimeException("Page empty", e);
        }
        return weather;
    }
}
