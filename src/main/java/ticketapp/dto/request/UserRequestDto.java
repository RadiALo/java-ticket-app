package ticketapp.dto.request;

import javax.validation.constraints.Size;
import lombok.Data;
import ticketapp.lib.Email;
import ticketapp.lib.FieldsValueMatch;

@Data
@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
public class UserRequestDto {
    @Email
    private String email;
    @Size(min = 8, max = 40)
    private String password;
    private String repeatPassword;
}
