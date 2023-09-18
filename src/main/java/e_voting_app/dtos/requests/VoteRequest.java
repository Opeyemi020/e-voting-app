package e_voting_app.dtos.requests;

import lombok.Data;

@Data
public class VoteRequest {

    private String voterId;
    private String partyName;
}
