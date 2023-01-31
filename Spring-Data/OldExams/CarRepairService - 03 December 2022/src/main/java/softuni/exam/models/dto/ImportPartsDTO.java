package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImportPartsDTO {

    @Size(min = 2, max = 19)
    private String partName;
    @Min(10)
    @Max(2000)
    private double price;
    @Positive
    private int quantity;
}
