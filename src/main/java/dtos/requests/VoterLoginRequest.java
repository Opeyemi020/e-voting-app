package dtos.requests;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VoterLoginRequest {
    private String emailAddress;
    private String password;
}
