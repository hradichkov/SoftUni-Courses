package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class MechanicNameDTO {
    @NotNull
    @XmlElement
    private String firstName;
}
