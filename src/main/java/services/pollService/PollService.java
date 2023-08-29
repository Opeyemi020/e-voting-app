package services.pollService;

import dtos.requests.VoteRequest;
import dtos.responses.VoteResponse;

import java.util.TreeMap;

public interface PollService {
    VoteResponse castVote(VoteRequest voteRequest);
    long countAllVotes(String partyName);
    TreeMap<String, Long> getResult();
}
