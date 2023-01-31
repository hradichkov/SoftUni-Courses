package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImportMechanicsDTO {
    @Email
    private String email;
    @Size(min = 2)
    private String firstName;
    @Size(min = 2)
    private String lastName;
    @Size(min = 2)
    private String phone;
}
