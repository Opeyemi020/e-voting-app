package e_voting_app.controllers;

import e_voting_app.dtos.requests.RegisterPartyRequest;
import e_voting_app.dtos.responses.RegisterPartyResponse;
import e_voting_app.exceptions.PartyAlreadyExistException;
import e_voting_app.services.partyService.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyController {


        @Autowired
        private PartyService partyService;

        @PostMapping("/party/register")
        public ResponseEntity<?> register(@RequestBody RegisterPartyRequest registerPartyRequest){
            try{
                RegisterPartyResponse response = partyService.registerNewParty(registerPartyRequest).getBody();
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (PartyAlreadyExistException e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
    }
