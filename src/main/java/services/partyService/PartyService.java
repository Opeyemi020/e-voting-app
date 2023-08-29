package services.partyService;

import dtos.requests.RegisterPartyRequest;
import dtos.responses.RegisterPartyResponse;
import exceptions.PartyAlreadyExistException;
import exceptions.PartyDoesNotExistException;

public interface PartyService {
    RegisterPartyResponse registerNewParty(RegisterPartyRequest request)throws PartyAlreadyExistException;
    RegisterPartyResponse findByName(String name)throws PartyDoesNotExistException;
}
