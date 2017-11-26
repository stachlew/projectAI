package pl.wat.db.repository.personality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.personality.PersonalityCategory;

public interface PersonalityCategoryRepository extends JpaRepository<PersonalityCategory, Long> {
}
