package validations;

import data.repository.PollRepository;
import exceptions.OverVotingException;

public class PollValidation {
    public static void validateOverVote(String voterId, PollRepository repository){
        if (repository.findByVoterId(voterId) != null)throw new OverVotingException("voter has already voted");
    }
}
