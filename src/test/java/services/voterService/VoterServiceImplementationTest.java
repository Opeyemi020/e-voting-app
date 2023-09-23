package services.voterService;

import e_voting_app.data.repository.VoterRepository;
import e_voting_app.dtos.requests.RegisterVoterRequest;
import e_voting_app.dtos.requests.VoterLoginRequest;
import e_voting_app.dtos.responses.VoterLoginResponse;
import e_voting_app.exceptions.*;
import e_voting_app.services.voterService.VoterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static e_voting_app.utils.AppUtils.ONE;
import static e_voting_app.utils.AppUtils.VOTER_SUCCESSFULLY_LOGGED_IN;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class VoterServiceImplementationTest {

    private final VoterService voterService;

    private final VoterRepository voterRepository;

    private final RegisterVoterRequest voterRequest;

    @Autowired
    VoterServiceImplementationTest(VoterService voterService, VoterRepository voterRepository, RegisterVoterRequest voterRequest) {
        this.voterService = voterService;
        this.voterRepository = voterRepository;
        this.voterRequest = voterRequest;
    }

    @BeforeEach
    public void setUp() {
        voterRepository.deleteAll();
        String firstname = "aiyeola";
        String lastname = "oluwatobiloba";
        int age = 22;
        String secretKey = "password";
        voterRequest = new RegisterVoterRequest().builder()
                .firstName(firstname)
                .lastName(lastname)
                .age(String.valueOf(age))
                .password(secretKey)
                .build();
        voterRequest.setFirstName(firstname);
        voterRequest.setLastName(lastname);
        voterRequest.setAge(String.valueOf(age));
        voterRequest.setEmailAddress("esther@gmail.com");
        voterRequest.setPassword("password");
        voterService.registerNewVoter(voterRequest);
    }

    @Test
    @DisplayName("Register voter test")
    public void testThatVoterCanBeRegistered() {
        assertEquals(ONE, voterRepository.count());
        assertNotNull(voterRepository);
    }

    @Test
    @DisplayName("Cannot register a Null field")
    public void testThatNullFieldsCannotBeRegistered() {
        String isEmpty = "";
        int NotAnAge = 0;
        voterRequest = new RegisterVoterRequest().builder()
                .age(String.valueOf(NotAnAge))
                .emailAddress(isEmpty)
                .firstName(isEmpty)
                .lastName(isEmpty)
                .password(isEmpty)
                .build();
        assertThrows(RequestHasNullFieldException.class, () -> voterService.registerNewVoter(voterRequest));
    }
    @Test
    @DisplayName("Login Test")
    public void testThatUserCanLogIn() throws VoterNotRegisteredException, IncorrectPasswordException {
        String email = "sulty@gmail.com";
        String secretKey = "1111";
        VoterLoginRequest voterLogInRequest = new VoterLoginRequest().builder()
                .emailAddress(email)
                .password(secretKey)
                .build();
        VoterLoginResponse voterLogInResponse = voterService.login(voterLogInRequest);
        assertEquals(String.format(VOTER_SUCCESSFULLY_LOGGED_IN), voterLogInResponse.getMessage());
        assertNotNull(voterLogInResponse.getMessage());
    }

    @Test
    @DisplayName("Unregistered voter can't log in")
    public void unregisteredVoterCan_tLogInTest() {
        VoterLoginRequest voterLogInRequest = new VoterLoginRequest();
        String email = "sulty33@gmail.com";
        String secretKey = "1131";
        voterLogInRequest.setEmailAddress(email);
        voterLogInRequest.setPassword(secretKey);
        assertThrows(VoterNotRegisteredException.class, () -> voterService.login(voterLogInRequest));
    }
    @Test
    @DisplayName("Wrong password throws an exception")
    public void userWithWrongPasswordCan_tLoginTest(){
        VoterLoginRequest voterLogInRequest = new VoterLoginRequest();
        voterLogInRequest.setEmailAddress("aliyah@gmail.com");
        voterLogInRequest.setPassword("1235");
        assertThrows(IncorrectPasswordException.class, () -> voterService.login(voterLogInRequest));
    }
    @Test
    @DisplayName("Invalid email format throws an exception")
    public void testThatInvalidEmailFormatThrowsAnException() {
        String firstname = "aiyeola";
        String lastname = "oluwatobiloba";
        int age = 22;
        String secretKey = "password";
        String email = "esthergmail.com";
        voterRequest = new RegisterVoterRequest().builder()
                .firstName(firstname)
                .lastName(lastname)
                .age(String.valueOf(age))
                .password(secretKey)
                .build();
        voterService.registerNewVoter(voterRequest);
        assertThrows(InvalidEmailFormatException.class, () -> voterService.registerNewVoter(voterRequest));
    }

    @Test
    @DisplayName("User below 18 cannot register")
    public void userBelowEighteenCannotRegisterTest(){
        String firstname = "aiyeola";
        String lastname = "oluwatobiloba";
        int age = 15;
        String secretKey = "password";
        String email = "esthergmail.com";
        voterRequest = new RegisterVoterRequest().builder()
                .firstName(firstname)
                .lastName(lastname)
                .age(String.valueOf(age))
                .password(secretKey)
                .emailAddress(email)
                .build();
        assertThrows(AdolescentVotingException.class, () -> voterService.registerNewVoter(voterRequest));
    }

}
