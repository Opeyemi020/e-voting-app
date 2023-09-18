package e_voting_app.services.voterService;

import e_voting_app.data.models.Voter;
import e_voting_app.data.repository.VoterRepository;
import e_voting_app.dtos.requests.RegisterVoterRequest;
import e_voting_app.dtos.requests.VoterLoginRequest;
import e_voting_app.dtos.responses.RegisterVotersResponse;
import e_voting_app.dtos.responses.VoterLoginResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static e_voting_app.utils.AppUtils.*;
import static e_voting_app.validations.PollValidation.validateOverVote;
import static e_voting_app.validations.VoterValidation.*;

@Service
@AllArgsConstructor

public class VoterServiceImplementation implements VoterService{

    private final VoterRepository voterRepository;

    private ModelMapper mapper;



    @Override
    public RegisterVotersResponse registerNewVoter(RegisterVoterRequest request) {
    validateRequestField(request);
    voterAgeValidation(Integer.parseInt(request.getAge()));
    validateEmailAddressFormat(request.getEmailAddress());
    validateOverVote(request.getEmailAddress(),voterRepository);
    Voter voter = mapper.map(request,Voter.class);
    hashPassword(request.getPassword());
        assert voter != null;
        voterRepository.save(voter);
        RegisterVotersResponse
                response = buildVoterResponse(voter);
        response.setMessage(String.format(VOTER_REGISTERED_SUCCESSFULLY));
        return response;
    }

    @Override
    public long countAllVoters() {
        return voterRepository.count();
    }

    @Override
    public VoterLoginResponse login(VoterLoginRequest request) {
        Optional<Voter> foundVoter = voterRepository.findByEmailAddress(request.getEmailAddress());
        registeredVoterValidation(foundVoter);
        Voter voter = foundVoter.get();
        checkPassword(request.getPassword(), voter.getPassword());
        return VoterLoginResponse.builder()
                .message(String.format(VOTER_SUCCESSFULLY_LOGGED_IN))
                .build();

    }
    public static RegisterVotersResponse buildVoterResponse(Voter voter){
        return RegisterVotersResponse.builder()
                .name(voter.getFirstName() + " " + voter.getLastName())
                .message(VOTER_REGISTERED_SUCCESSFULLY)
                .build();
    }
}

