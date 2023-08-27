package dtos.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RegisterVoterRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String age;
    private String password;
}
