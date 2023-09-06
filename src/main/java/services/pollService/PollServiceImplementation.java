package services.pollService;

import data.models.Party;
import data.repository.PartyRepository;
import data.repository.PollRepository;
import data.repository.VoterRepository;
import dtos.requests.VoteRequest;
import dtos.responses.VoteResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import utils.Mapper;

import java.util.TreeMap;

import static validations.VoterValidation.validateDuplicateVoter;
@Service
@AllArgsConstructor

public class PollServiceImplementation implements PollService{

    private final PollRepository pollRepository;
    private final PartyRepository partyRepository;

    @Override
    public VoteResponse castVote(VoteRequest voteRequest) {
        validateDuplicateVoter(voteRequest.getVoterId(), (VoterRepository) pollRepository);
        return Mapper.map(pollRepository.save(Mapper.map(voteRequest)));
    }


    @Override
    public long countAllVotes(String partyName) {
        return pollRepository.countPollByPartyName(partyName);
    }

    @Override
    public TreeMap<String, Long> getResult() {
        TreeMap<String,Long> map = new TreeMap<>();
        for (Party party: partyRepository.findAll()) {
            map.put(party.getName(),pollRepository.countPollByPartyName(party.getName()));
        }
        return map;
    }
}