package e_voting_app.dtos.requests;

import lombok.Data;

@Data

public class RegisterPartyRequest {
    private String name;
    private String candidate;
}
