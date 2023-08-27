package data.models;

import lombok.NonNull;
import org.springframework.data.annotation.Id;

public class Poll {
    @Id
    private String voterId;
    @NonNull
    private String partyName;
}
