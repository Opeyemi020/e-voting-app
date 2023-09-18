package e_voting_app.data.repository;

import e_voting_app.data.models.Voter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface VoterRepository extends MongoRepository<Voter, String> {
    Optional<Voter> findByEmailAddress(String email);

    Voter findByVoterId(String voterId);
}
