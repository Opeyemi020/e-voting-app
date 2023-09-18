package e_voting_app.services.voterService;

import e_voting_app.dtos.requests.RegisterVoterRequest;
import e_voting_app.dtos.requests.VoterLoginRequest;
import e_voting_app.dtos.responses.VoterLoginResponse;
import e_voting_app.dtos.responses.RegisterVotersResponse;


public interface VoterService {
    RegisterVotersResponse registerNewVoter (RegisterVoterRequest request);
    long countAllVoters();
    VoterLoginResponse login(VoterLoginRequest request);
}
