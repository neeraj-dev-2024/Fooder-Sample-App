package n7.ai.fooder.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private final List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return  runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> runOptional = findById(id);
        runOptional.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id){
        Optional<Run> runOptional = findById(id);
        runOptional.ifPresent(runs::remove);
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(2, "Second run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 5, Location.OUTDOOR));
        runs.add(new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 10, Location.OUTDOOR));
        runs.add(new Run(3, "Third run",  LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.INDOOR));
    }
}

