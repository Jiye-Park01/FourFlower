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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    private Long board_id;
    private String comment_content;     //datetime
    private int comnet_regdate;
    private int comment_updatedate;  //datetime
    private int comment_deletedate;  //datetime
    private int comment_order;
    private int comment_group;
    private int comment_depth;
    private int comment_like;
}