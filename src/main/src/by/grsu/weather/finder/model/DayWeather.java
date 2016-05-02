package by.grsu.weather.finder.model;

import javax.persistence.*;
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
    @Column(name = "day_id")
    private Long id;

    @Temporal(TemporalType.DATE)
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

    public Weather getNight() {
        return weatherList.get(0);
    }

    public void setNight(Weather night) {
        this.weatherList.set(0, night);
        night.setDayWeather(this);
    }

    public Weather getMorning() {
        return this.weatherList.get(1);
    }

    public void setMorning(Weather morning) {
        this.weatherList.set(1, morning);
        morning.setDayWeather(this);
    }

    public Weather getDay() {
        return this.weatherList.get(2);
    }

    public void setDay(Weather day) {
        this.weatherList.set(2, day);
        day.setDayWeather(this);
    }

    public Weather getEvening() {
        return this.weatherList.get(3);
    }

    public void setEvening(Weather evening) {
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

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getNight().toString());
        buffer.append("\n");
        buffer.append(getMorning().toString());
        buffer.append("\n");
        buffer.append(getDay().toString());
        buffer.append("\n");
        buffer.append(getEvening().toString());
        buffer.append("\n");
        return buffer.toString();
    }
}
