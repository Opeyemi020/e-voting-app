package services.partyService;

import data.models.Party;
import data.repository.PartyRepository;
import dtos.requests.RegisterPartyRequest;
import dtos.responses.RegisterPartyResponse;
import exceptions.PartyAlreadyExistException;
import exceptions.PartyDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import utils.Mapper;

import java.util.Optional;

import static validations.PartyValidation.existingPartyValidation;

@Service

@AllArgsConstructor


public class PartyServiceImplementation implements PartyService {
    PartyRepository partyRepository;

    @Override
    public RegisterPartyResponse registerNewParty(RegisterPartyRequest request) throws PartyAlreadyExistException {
        existingPartyValidation(request.getName(), partyRepository);return Mapper.map(partyRepository.save(Mapper.map(request)));
    }

    @Override
    public RegisterPartyResponse findByName(String name) throws PartyDoesNotExistException {
        Optional<Party> party = partyRepository.findByName(name);
        if (party.isEmpty())throw new PartyDoesNotExistException("party does not exist");
        return Mapper.map(party.get());
    }
}
