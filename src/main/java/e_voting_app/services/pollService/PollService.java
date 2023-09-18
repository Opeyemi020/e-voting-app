package e_voting_app.services.pollService;

import e_voting_app.dtos.requests.VoteRequest;
import e_voting_app.dtos.responses.VoteResponse;

import java.util.TreeMap;

public interface PollService {
    VoteResponse castVote(VoteRequest voteRequest);
    long countAllVotes(String partyName);
    TreeMap<String, Long> getResult();
}
