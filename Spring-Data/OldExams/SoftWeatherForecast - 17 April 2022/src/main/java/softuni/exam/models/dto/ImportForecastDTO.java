package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.util.LocalTimeAdapter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportForecastDTO {
    @NotNull
    @XmlElement(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @Min(-20)
    @Max(60)
    @XmlElement(name = "max_temperature")
    private double maxTemperature;
    @Min(-50)
    @Max(40)
    @XmlElement(name = "min_temperature")
    private double minTemperature;

    @NotNull
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    @XmlElement
    private LocalTime sunrise;
    @NotNull
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    @XmlElement
    private LocalTime sunset;
    @XmlElement
    private Long city;

}
