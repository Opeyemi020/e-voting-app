package e_voting_app.services.partyService;

import e_voting_app.dtos.requests.RegisterPartyRequest;
import e_voting_app.dtos.responses.RegisterPartyResponse;
import e_voting_app.exceptions.PartyAlreadyExistException;
import e_voting_app.exceptions.PartyDoesNotExistException;
import org.springframework.http.ResponseEntity;

public interface PartyService {
    ResponseEntity<RegisterPartyResponse> registerNewParty(RegisterPartyRequest request)throws PartyAlreadyExistException;
    ResponseEntity<RegisterPartyResponse> findByName(String name)throws PartyDoesNotExistException;
}
