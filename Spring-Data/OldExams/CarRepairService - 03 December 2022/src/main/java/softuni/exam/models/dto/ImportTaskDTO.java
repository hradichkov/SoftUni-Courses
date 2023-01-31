package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.util.LocalDateTimeAdapter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTaskDTO {
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlElement
    private LocalDateTime date;
    @Positive
    @XmlElement
    private BigDecimal price;
    @NotNull
    @XmlElement
    private CarIdDTO car;
    @NotNull
    @XmlElement
    private MechanicNameDTO mechanic;
    @NotNull
    @XmlElement
    private PartIdDTO part;
}
