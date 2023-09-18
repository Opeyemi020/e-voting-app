package e_voting_app.dtos.responses;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterPartyResponse {
    private String message;
    private Object party;
}
