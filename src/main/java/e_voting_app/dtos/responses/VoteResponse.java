package e_voting_app.dtos.responses;

import lombok.Data;

@Data

public class VoteResponse {
    private String partyName;
    private String message;
    private String voterId;
}
