package com.example.xmlexercise.domain.dtos.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportProductsInRangeDTO {

    @XmlElement(name = "product")
    List<ProductWithAttributesDTO> products;
}
