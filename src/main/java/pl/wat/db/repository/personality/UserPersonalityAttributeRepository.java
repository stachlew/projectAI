package pl.wat.db.repository.personality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.personality.UserPersonalityAttribute;

public interface UserPersonalityAttributeRepository extends JpaRepository<UserPersonalityAttribute, Long> {
}
