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
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_id;
    private String board_name;
    private Long user_id;
    private String board_title;
    private String board_content;
    private int board_regdate;  //datetime
    private int board_updatedate;  //datetime
    private int board_deletedate;  //datetime
    private int board_like;
}
