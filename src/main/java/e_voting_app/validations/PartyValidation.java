package e_voting_app.validations;

import e_voting_app.data.repository.PartyRepository;
import e_voting_app.exceptions.PartyAlreadyExistException;

public class PartyValidation {
        public static void existingPartyValidation(String name, PartyRepository partyRepository) {
            if (partyRepository.findByName(name).isPresent())
                throw new PartyAlreadyExistException("party with" + name + "already exist");

        }
}
