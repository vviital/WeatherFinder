package by.grsu.weather.finder.model;

/**
 * Created by vviital on 5/6/16.
 */
public class City {

    private Long id;

    private String url;

    private String russianName;

    public City() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRussianName() {
        return russianName;
    }

    public void setRussianName(String russianName) {
        this.russianName = russianName;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("City - ");
        buffer.append(russianName);
        buffer.append("\t");
        buffer.append("Url - ");
        buffer.append(url);
        buffer.append("\n");
        return buffer.toString();
    }
}
