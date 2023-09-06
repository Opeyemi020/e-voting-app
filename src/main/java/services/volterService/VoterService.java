package services.volterService;

import dtos.requests.RegisterVoterRequest;
import dtos.requests.VoterLoginRequest;
import dtos.responses.VoterLoginResponse;
import dtos.responses.RegisterVotersResponse;
import org.springframework.stereotype.Service;

@Service
public interface VoterService {
    RegisterVotersResponse registerNewVoter (RegisterVoterRequest request);
    long countAllVoters();
    VoterLoginResponse login(VoterLoginRequest request);
}
