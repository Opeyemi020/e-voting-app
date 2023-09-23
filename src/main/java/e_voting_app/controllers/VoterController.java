package e_voting_app.controllers;

public class VoterController {
    @RestController
    @AllArgsConstructor
    public class VoterController {
        private final VoterService voterService;
        @PostMapping("/voter/register")
        public ResponseEntity<?> register(@RequestBody RegisterVoterRequest request) {
            RegisterVoterResponse response = voterService.registerNewVoter(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        @PostMapping("/voter/login")
        public ResponseEntity<?> login(@RequestBody VoterLogInRequest request){
            VoterLogInResponse response = voterService.logIn(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
}
