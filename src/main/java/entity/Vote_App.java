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
public class Vote_App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vote_app_id;
    private String vote_app_headline;
    private String vote_app_contents;
    private int vote_app_regdate;   //datetime
    private int vote_app_deadline;  //datetime
}
