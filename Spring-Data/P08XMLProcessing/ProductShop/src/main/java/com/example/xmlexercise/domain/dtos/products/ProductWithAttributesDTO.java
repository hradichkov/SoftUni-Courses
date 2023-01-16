package com.example.xmlexercise.domain.dtos.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWithAttributesDTO {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private BigDecimal price;
    @XmlAttribute
    private String seller;
}
