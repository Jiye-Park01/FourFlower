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
public class ChatApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatapp_id;
    private Long user_id;
    private Long chattingroom_id;
}
