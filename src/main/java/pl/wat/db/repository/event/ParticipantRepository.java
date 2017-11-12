package pl.wat.db.repository.event;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.db.domain.event.Event;
import pl.wat.db.domain.event.Participant;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
     List<Participant> findByEvent(Event event);

}
