package by.grsu.weather.finder.httpPageParser;

import by.grsu.weather.finder.model.City;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vviital on 5/6/16.
 */
public class FindListCities {
    public static List<City> find() {
        List<City> result = new ArrayList<City>();
        String url = "http://meteo.by/";
        try {
            Document doc = Jsoup.connect(url).get();
            Element element = doc.select("ul.cities").first();
            Elements elements = element.select("li");
            for(Element node : elements) {
                City city = new City();
                String currentCity = node.child(0).attr("href").split("/")[1];
                String russianName = node.child(0).text();
                city.setRussianName(russianName);
                city.setUrl(currentCity);
                result.add(city);
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't find cities", e);
        }
        return result;
    }
}
