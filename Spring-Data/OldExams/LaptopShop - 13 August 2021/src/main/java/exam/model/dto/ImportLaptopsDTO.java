package exam.model.dto;

import exam.model.entity.Shop;
import exam.model.entity.WarrantyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImportLaptopsDTO {

    @Size(min = 9)
    private String macAddress;
    @Positive
    private double cpuSpeed;
    @Min(8)
    @Max(128)
    private int ram;
    @Min(128)
    @Max(1024)
    private int storage;
    @Size(min = 10)
    private String description;
    @Positive
    private BigDecimal price;
    @NotNull
    private WarrantyType warrantyType;
    private ShopNameDTO shop;
}
