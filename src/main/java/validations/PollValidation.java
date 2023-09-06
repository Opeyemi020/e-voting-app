package validations;

import data.repository.VoterRepository;
import exceptions.OverVotingException;

public class PollValidation {
    public static void validateOverVote(String voterId, VoterRepository repository){
        if (repository.findByVoterId(voterId) != null)throw new OverVotingException("voter has already voted");
    }
}
