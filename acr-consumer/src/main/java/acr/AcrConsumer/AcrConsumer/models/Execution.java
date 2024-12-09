package acr.AcrConsumer.AcrConsumer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EXECUTION")
public class Execution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "execution_seq")
    @SequenceGenerator(name = "execution_seq", sequenceName = "execution_sequence", allocationSize = 1)
    private Long id;
    private TipoStatusEnum tpStatus;
    private LocalDateTime dhRequest;
    private LocalDateTime dhStarted;
    private LocalDateTime dhEnded;
    private Integer qtAttempt;
    private String dsDetail;
    private Integer qtIssue;
    private Long idProject;
}
