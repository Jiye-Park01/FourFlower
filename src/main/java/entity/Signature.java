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
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long signature_id;
    private Long is_pinned;
    private int signature_regdate;  //datetime
    private int signature_deadline; //datetime
    private Long writer_user_id;
    private Long joining_user_id;
    private int joining_dong;
    private int joining_ho;
}
