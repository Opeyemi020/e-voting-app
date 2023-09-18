package e_voting_app.services.pollService;

import e_voting_app.data.models.Party;
import e_voting_app.data.repository.PartyRepository;
import e_voting_app.data.repository.PollRepository;
import e_voting_app.dtos.requests.VoteRequest;
import e_voting_app.dtos.responses.VoteResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.TreeMap;
import java.util.stream.Collectors;

import static e_voting_app.validations.VoterValidation.validateDuplicateVoter;
@Service
@AllArgsConstructor

public class PollServiceImplementation implements PollService{
    private ModelMapper mapper;
    private final PollRepository pollRepository;
    private final PartyRepository partyRepository;

    @Override
    public VoteResponse castVote(VoteRequest voteRequest) {
        validateDuplicateVoter(voteRequest.getVoterId(),  pollRepository);
//        return mapper.map(pollRepository.save(mapper.map()));
        return null;
    }


    @Override
    public long countAllVotes(String partyName) {
        return pollRepository.countPollByPartyName(partyName);
    }

    @Override
    public TreeMap<String, Long> getResult() {
        TreeMap<String, Long> map = partyRepository.findAll().stream()
                .collect(Collectors.toMap(
                        Party::getName,
                        party -> pollRepository.countPollByPartyName(party.getName()),
                        (existingValue, newValue) -> existingValue,
                        TreeMap::new
                ));
        return map;
    }
}