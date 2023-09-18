package e_voting_app.data.repository;

import e_voting_app.data.models.Poll;
import e_voting_app.data.models.Voter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PollRepository extends MongoRepository<Poll, String> {
    Voter findByVoterId(String voterId);
    List<Poll> findPollsByPartyName(String partyName);
    Long countPollByPartyName(String partyName);
    Optional findByEmailAddress(String email);


}
