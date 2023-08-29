package services.pollService;

import dtos.requests.VoteRequest;
import dtos.responses.VoteResponse;

import java.util.TreeMap;

public class PollServiceImplementation implements PollService{

    @Override
    public VoteResponse castVote(VoteRequest voteRequest) {

        return null;
    }

    @Override
    public long countAllVotes(String partyName) {
        return 0;
    }

    @Override
    public TreeMap<String, Long> getResult() {
        return null;
    }
}
//    @Override
//    public VoteResponse castVote(VoteRequest voteRequest){
//        validateOverVoting(voteRequest.getVoterId(), pollRepo);
//        return Mapper.map(pollRepo.save(Mapper.map(voteRequest)));
//    }
//    @Override
//    public long countAllVote(String partyName) {
//        return pollRepo.countPollsByPartyName(partyName);
//    }
//
//    @Override
//    public TreeMap<String, Long> getResult() {
//        TreeMap<String, Long> map = new TreeMap<>();
//        for (Party party: partyRepository.findAll()) {
//            map.put(party.getName(), pollRepo.countPollsByPartyName(party.getName()));
//        }
//        return map;