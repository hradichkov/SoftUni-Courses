package softuni.exam.models.dto;

import com.google.gson.annotations.SerializedName;
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
public class ImportAgentsDTO {
    @Size(min = 2)
    private String firstName;
    @Size(min = 2)
    private String lastName;
    @SerializedName("town")
    private String townName;
    @Email
    private String email;
}
