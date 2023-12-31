package e_voting_app.validations;

import e_voting_app.data.models.Voter;
import e_voting_app.data.repository.PollRepository;
import e_voting_app.dtos.requests.RegisterVoterRequest;
import e_voting_app.exceptions.*;

import java.util.Optional;
import java.util.regex.Pattern;

import static e_voting_app.utils.AppUtils.*;

public class VoterValidation {
    public static void registeredVoterValidation(Optional<Voter> voter){
        if (voter.isEmpty())throw new VoterNotRegisteredException("Not a registered voter!!");
    }
    public static void validateDuplicateVoter(String emailAddress, PollRepository repository){
            if (repository.findByEmailAddress(emailAddress).isPresent()) {
                throw new VoterAlreadyExistException(String.format(VOTER_WITH_EMAIL_EXISTS, emailAddress));
            }
        }
    public static void validateEmailAddressFormat(String emailAddress){
        if (!Pattern.matches(EMAIL_PATTERN, emailAddress))throw new InvalidEmailFormatException("Invalid email Address");
    }
    public static void voterAgeValidation(int age){
        if (age < EIGTHEEN) throw new AdolescentVotingException(MINIMUM_VOTER_AGE_IS_EIGHTEEN);
    }
    public static void validateRequestField(RegisterVoterRequest request){
        if (request.getEmailAddress() == null || request.getEmailAddress().isEmpty() || request.getEmailAddress().isBlank()||
                request.getFirstName() == null || request.getFirstName().isBlank() || request.getFirstName().isEmpty() || request.getLastName() == null ||
                request.getLastName().isEmpty() || request.getLastName().isBlank() || request.getLastName().equals("null") || request.getAge().equals("null") ||
                request.getAge().isEmpty() || request.getAge().isBlank() || request.getAge().equals("null")) throw new RequestHasNullFieldException("All fields are required");
    }
}
