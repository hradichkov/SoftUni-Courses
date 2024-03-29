package exam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportShopDTO {
    @Size(min = 4)
    @XmlElement
    private String address;
    @Min(1)
    @Max(50)
    @XmlElement(name = "employee-count")
    private int employeeCount;
    @Min(2000)
    @XmlElement
    private BigDecimal income;
    @Size(min = 4)
    @XmlElement
    private String name;
    @Min(150)
    @XmlElement(name = "shop-area")
    private int shopArea;

    @XmlElement
    private TownNameDTO town;
}
