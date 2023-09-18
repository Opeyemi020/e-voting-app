package e_voting_app.validations;

import e_voting_app.data.repository.VoterRepository;
import e_voting_app.exceptions.OverVotingException;

public class PollValidation {
    public static void validateOverVote(String voterId, VoterRepository repository){
        if (repository.findByVoterId(voterId) != null)throw new OverVotingException("voter has already voted");
    }
}
