package by.grsu.weather.finder.model;

import javax.persistence.*;

/**
 * Created by vviital on 1.5.16.
 */

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "weather_id")
    private Long id;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "pressure")
    private String pressure;

    @Column(name = "windSpeed")
    private String windSpeed;

    @Column(name = "windDirection")
    private String windDirection;

    @Column(name = "cloudiness")
    private String cloudiness;

    @Column(name = "humidity")
    private String humidity;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private DayWeather dayWeather;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(String cloudiness) {
        this.cloudiness = cloudiness;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayWeather getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(DayWeather dayWeather) {
        this.dayWeather = dayWeather;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("temperature = ");
        buffer.append(temperature);
        buffer.append("\t");
        buffer.append("pressure = ");
        buffer.append(pressure);
        buffer.append("\t");
        buffer.append("humidity = ");
        buffer.append(humidity);
        buffer.append("\t");
        buffer.append("windSpeed = ");
        buffer.append(windSpeed);
        buffer.append("\t");
        buffer.append("windDirection = ");
        buffer.append(windDirection);
        buffer.append("\t");
        buffer.append("cloudiness = ");
        buffer.append(cloudiness);
        return buffer.toString();
    }
}
