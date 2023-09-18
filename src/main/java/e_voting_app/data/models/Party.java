package e_voting_app.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Document("Parties")
@AllArgsConstructor
@NoArgsConstructor
public class Party {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String candidate;
}
