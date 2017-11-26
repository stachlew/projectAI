package pl.wat.db.repository.event;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import pl.wat.db.domain.event.Event;
import pl.wat.logic.dto.event.EventSearchDTO;

public interface EventRepositoryCustom {

    Slice<Event> findEventByFilter(EventSearchDTO filter, Pageable pageable);
}
