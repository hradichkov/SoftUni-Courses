package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.CarType;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCarDTO {
    @Size(min = 2, max = 30)
    @XmlElement
    private String carMake;
    @Size(min = 2, max = 30)
    @XmlElement
    private String carModel;
    @Positive
    @XmlElement
    private int year;
    @Size(min = 2, max = 30)
    @XmlElement
    private String plateNumber;
    @Positive
    @XmlElement
    private int kilometers;
    @Min(1)
    private double engine;
    @XmlElement
    private CarType carType;
}
