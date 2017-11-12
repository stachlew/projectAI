package pl.wat.db.repository.event;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.event.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {
}
