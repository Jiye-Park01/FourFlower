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

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long device_id;
    private String device_token;
    private Long user_id;
}
