package pl.wat.db.repository.event;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.event.Localization;

public interface LocalizatonRepository extends CrudRepository<Localization, Long> {
}
