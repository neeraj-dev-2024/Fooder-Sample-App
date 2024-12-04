package n7.ai.fooder.run;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;


// Run Class is Immutable. It has a private constructor and a public record.
public record Run(
        @Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        @Version
        Integer version,
        Location location
) {
    public Run {
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("Run cannot be completed before it started");
        }
    }
}
