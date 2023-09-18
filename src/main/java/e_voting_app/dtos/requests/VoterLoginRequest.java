package e_voting_app.dtos.requests;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoterLoginRequest {
    private String emailAddress;
    private String password;
}
