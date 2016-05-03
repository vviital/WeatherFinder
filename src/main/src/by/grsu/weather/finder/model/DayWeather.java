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
        for(int i = 0; i < 4; ++i)
            weatherList.add(new Weather());
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @JsonIgnore
    public Weather getNightWeather() {
        return weatherList.get(0);
    }

    public void setNightWeather(Weather night) {
        this.weatherList.set(0, night);
        night.setDayWeather(this);
    }

    @JsonIgnore
    public Weather getMorningWeather() {
        return this.weatherList.get(1);
    }

    public void setMorning(Weather morning) {
        this.weatherList.set(1, morning);
        morning.setDayWeather(this);
    }

    @JsonIgnore
    public Weather getDaytimeWeather() {
        return this.weatherList.get(2);
    }

    public void setDaytimeWeather(Weather day) {
        this.weatherList.set(2, day);
        day.setDayWeather(this);
    }

    @JsonIgnore
    public Weather getEveningWeather() {
        return this.weatherList.get(3);
    }

    public void setEveningWeather(Weather evening) {
        this.weatherList.set(3, evening);
        evening.setDayWeather(this);
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

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getNightWeather().toString());
        buffer.append("\n");
        buffer.append(getMorningWeather().toString());
        buffer.append("\n");
        buffer.append(getDaytimeWeather().toString());
        buffer.append("\n");
        buffer.append(getEveningWeather().toString());
        buffer.append("\n");
        return buffer.toString();
    }
}
