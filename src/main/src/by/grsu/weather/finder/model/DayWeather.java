package by.grsu.weather.finder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by vviital on 1.5.16.
 */
@Entity
@Table(name = "days")
public class DayWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "day_id", nullable = false)
    private Long id;

    @JsonIgnore
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar date;

    @OneToMany(mappedBy = "dayWeather", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Weather> weatherList = new ArrayList<Weather>();

    public DayWeather() {

    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(getDate().getTime());
    }

    public void addWeather(Weather weather) {
        this.weatherList.add(weather);
    }

    public void bindWeather() {
        for(Weather weather : weatherList) {
            weather.setDayWeather(this);
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for(Weather weather : weatherList) {
            buffer.append(weather.toString());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
