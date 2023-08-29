package utils;

import data.models.Party;
import data.models.Poll;
import dtos.requests.RegisterPartyRequest;
import dtos.requests.VoteRequest;
import dtos.responses.RegisterPartyResponse;
import dtos.responses.VoteResponse;

import static utils.AppUtils.VOTE_SUCCESSFUL;

public class Mapper {
    public static VoteResponse map(Poll poll){
        VoteResponse voteResponse = new VoteResponse();
        voteResponse.setPartyName(poll.getPartyName());
        voteResponse.setVoterId(poll.getVoterId());
        voteResponse.setMessage(VOTE_SUCCESSFUL);
        return voteResponse;
    }


    public static Poll map(VoteRequest voteRequest) {
        Poll poll = new Poll();
        poll.setPartyName(voteRequest.getPartyName());
        poll.setVoterId(voteRequest.getVoterId());
        return poll;
    }

    public static Party map(RegisterPartyRequest request) {
        Party party = new Party();
        party.setName(request.getName());
        party.setCandidate(request.getCandidate());
        return party;
    }

    public static RegisterPartyResponse map(Party party) {
        RegisterPartyResponse response = new RegisterPartyResponse();
        response.setId(party.getId());
        response.setName(party.getName());
        response.setCandidate(party.getCandidate());
        return response;
    }
}
