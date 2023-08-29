package validations;

import data.repository.PartyRepository;
import exceptions.PartyAlreadyExistException;

public class PartyValidation {
        public static void existingPartyValidation(String name, PartyRepository partyRepository) {
            if (partyRepository.findByName(name).isPresent())
                throw new PartyAlreadyExistException("party with" + name + "already exist");

        }
}
