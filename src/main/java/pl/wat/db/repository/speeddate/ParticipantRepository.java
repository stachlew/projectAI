package pl.wat.db.repository.speeddate;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.speeddate.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Integer> {
}
