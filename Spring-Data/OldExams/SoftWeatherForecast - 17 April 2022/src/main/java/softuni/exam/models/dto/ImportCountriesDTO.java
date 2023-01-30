package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImportCountriesDTO {

    @Size(min = 2)
    @Size(max = 60)
    private String countryName;

    @Size(min = 2)
    @Size(max = 20)
    private String currency;
}
