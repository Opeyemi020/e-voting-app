package services.volterService;

import data.models.Voter;
import data.repository.VoterRepository;
import dtos.requests.RegisterVoterRequest;
import dtos.requests.VoterLoginRequest;
import dtos.responses.RegisterVotersResponse;
import dtos.responses.VoterLoginResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import utils.Mapper;

import java.util.Optional;

import static utils.AppUtils.*;
import static validations.PollValidation.validateOverVote;
import static validations.VoterValidation.*;

@Service
@AllArgsConstructor
@Slf4j

public class VoterServiceImplementation implements VoterService{
    private final VoterRepository voterRepository;
    private final Mapper mapper;

    @Override
    public RegisterVotersResponse registerNewVoter(RegisterVoterRequest request) {
    validateRequestField(request);
    voterAgeValidation(Integer.parseInt(request.getAge()));
    validateEmailAddressFormat(request.getEmailAddress());
    validateOverVote(request.getEmailAddress(),voterRepository);
    Voter voter = Mapper.map(request,Voter.class);
    hashPassword(request.getPassword());
        assert voter != null;
        voterRepository.save(voter);
        RegisterVotersResponse
                response = buildVoterResponse(voter);
        response.setMessage(String.format(VOTER_REGISTERED_SUCCESSFULLY));
        log.info(String.format(VOTER_REGISTERED_SUCCESSFULLY));
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
        log.info(String.format(VOTER_SUCCESSFULLY_LOGGED_IN));
        return VoterLoginResponse.builder()
                .id(voter.getId())
                .message(String.format(VOTER_SUCCESSFULLY_LOGGED_IN))
                .build();

    }
    public static RegisterVotersResponse buildVoterResponse(Voter voter){
        return RegisterVotersResponse.builder()
                .name(voter.getFirstName() + " " + voter.getLastName())
                .voterId(voter.getId())
                .build();
    }
}

