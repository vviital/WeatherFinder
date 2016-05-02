import by.grsu.weather.finder.custom.tests.Tests;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by vviital on 1.5.16.
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "by.grsu.weather.finder")
@EnableJpaRepositories(basePackages = {"by.grsu.weather.finder.repositories.interfaces"})
@EntityScan(basePackages = "by.grsu.weather.finder.model")
public class Starter {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Starter.class, args);
        Tests tests = context.getBean(Tests.class);
        tests.test();
//        WeatherFinderImpl finder = new WeatherFinderImpl();
//        Calendar day = new GregorianCalendar(2013, 8, 1);
//        for(int i = 0; i < 200; ++i) {
//            finder.find(day);
//            day.add(Calendar.DAY_OF_YEAR, 1);
//        }
    }

    @Bean
    public Tests getBean() {
        return new Tests();
    }
}
