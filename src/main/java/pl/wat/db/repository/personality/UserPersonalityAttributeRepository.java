package pl.wat.db.repository.personality;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.personality.UserPersonalityAttribute;

public interface UserPersonalityAttributeRepository extends CrudRepository<UserPersonalityAttribute, Integer>{
}
