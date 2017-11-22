package pl.wat.db.repository.event;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.db.domain.event.Event;
import pl.wat.db.domain.event.Participant;
import pl.wat.db.domain.user.User;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
     List<Participant> findByEvent(Event event);
     List<Participant> findByUser(User user);
     Participant findFirstByEventAndUser(Event event,User user);

     int countByEvent(Event event);

}
