package pl.wat.db.repository.speeddate;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.speeddate.Localization;

public interface LocalizatonRepository extends CrudRepository<Localization, Integer> {
}
