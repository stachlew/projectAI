package pl.wat.db.repository.event;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.event.EventPicture;

public interface EventPictureRepository extends CrudRepository<EventPicture, Long> {
}
