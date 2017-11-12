package pl.wat.db.repository.event;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.event.Event;
import pl.wat.db.domain.user.User;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findByAndOrganizer(User organizer);

}
