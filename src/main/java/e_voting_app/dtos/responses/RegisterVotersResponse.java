package e_voting_app.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterVotersResponse {
    private String name;
    private String message;
}
