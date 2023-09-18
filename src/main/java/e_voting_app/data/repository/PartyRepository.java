package e_voting_app.data.repository;

import e_voting_app.data.models.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PartyRepository extends MongoRepository<Party, String> {
    Optional<Party> findByName(String name);

}
