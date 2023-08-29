package data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
public class Poll {
    @Id
    private String voterId;
    @NonNull
    private String partyName;
}
