package data.repository;

import data.models.Poll;
import data.models.Voter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PollRepository extends MongoRepository<Poll, String> {
    Voter findByVoterId(String voterId);
    List<Poll> findPollsByPartyName(String partyName);
    Long countPollByPartyName(String partyName);


}
