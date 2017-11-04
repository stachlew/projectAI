package pl.wat.db.repository.speeddate;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.speeddate.Speeddate;

public interface SpeeddateRepository extends CrudRepository<Speeddate, Integer> {
}
