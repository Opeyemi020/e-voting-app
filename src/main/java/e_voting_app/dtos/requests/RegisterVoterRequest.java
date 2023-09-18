package e_voting_app.dtos.requests;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVoterRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;

    private String age;
    private String password;
}
