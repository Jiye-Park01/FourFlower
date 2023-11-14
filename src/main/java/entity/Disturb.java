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
public class Disturb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disturb_id;
    private int disturb_start_time; //time
    private int disturb_finish_time;    //time
    private Long user_id;
}
