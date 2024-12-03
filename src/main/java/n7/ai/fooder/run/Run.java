package n7.ai.fooder.run;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;


// Run Class is Immutable. It has a private constructor and a public record.
public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {
    public Run {
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("Run cannot be completed before it started");
        }
    }
}
