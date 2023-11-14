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
public class Board_Comment_Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_comment_report_id;
    private Long board_id;
    private Long comment_id;
    private Long chattingroom_id;
}
