package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;
    @Column(name = "max_temperature", nullable = false)
    private double maxTemperature;

    @Column(name = "min_temperature", nullable = false)
    private double minTemperature;

    @Column(nullable = false)
    private LocalTime sunrise;

    @Column(nullable = false)
    private LocalTime sunset;

    @ManyToOne(optional = false)
    private City city;

    @Override
    public String toString() {
        //City: {cityName}:
        //   		-min temperature: {minTemperature}
        //   		--max temperature: {maxTemperature}
        //   		---sunrise: {sunrise}
        //----sunset: {sunset}
        return "City: " + this.city.getCityName() + System.lineSeparator() +
                "-min temperature: " + this.minTemperature + System.lineSeparator() +
                "--max temperature: " + this.maxTemperature + System.lineSeparator() +
                "---sunrise: " + this.sunrise + System.lineSeparator() +
                "----sunset: " + this.sunset;
    }
}
