package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.ApartmentType;

import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportApartmentDTO {

    @XmlElement
    private ApartmentType apartmentType;
    @Min(40)
    @XmlElement
    private double area;

    @XmlElement(name = "town")
    private String townName;
}
