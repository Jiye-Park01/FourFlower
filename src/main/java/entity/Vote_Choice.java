package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote_Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vote_choice_id;
    private String vote_choice_content;
    private Long vote_count;
    private Long vote_app_id;
}
