package e_voting_app.services.partyService;

import e_voting_app.data.models.Party;
import e_voting_app.data.repository.PartyRepository;
import e_voting_app.dtos.requests.RegisterPartyRequest;
import e_voting_app.dtos.responses.RegisterPartyResponse;
import e_voting_app.exceptions.PartyAlreadyExistException;
import e_voting_app.exceptions.PartyDoesNotExistException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static e_voting_app.utils.AppUtils.PARTY_DOESNT_EXIST;
import static e_voting_app.utils.AppUtils.PARTY_REGISTERED_SUCCESSFULLY;
import static e_voting_app.validations.PartyValidation.existingPartyValidation;

@Service

@AllArgsConstructor


public class PartyServiceImplementation implements PartyService {

    private PartyRepository partyRepository;
    private ModelMapper mapper;

    @Override
    public ResponseEntity<RegisterPartyResponse> registerNewParty(RegisterPartyRequest request) throws PartyAlreadyExistException {
        existingPartyValidation(request.getName(), partyRepository);
        Party party = mapper.map(request, Party.class);
        partyRepository.save(party);
        RegisterPartyResponse response= RegisterPartyResponse.builder()
                .message(PARTY_REGISTERED_SUCCESSFULLY)
                .build();
        return ResponseEntity.ok().body(response);
    }


    @Override
    public ResponseEntity<RegisterPartyResponse> findByName(String name) throws PartyDoesNotExistException {
       Party party = partyRepository.findByName(name).orElseThrow(() ->
               new PartyDoesNotExistException(PARTY_DOESNT_EXIST));
       RegisterPartyResponse response = RegisterPartyResponse.builder()
               .party(party)
               .build();
        return ResponseEntity.ok().body(response);

    }
}
