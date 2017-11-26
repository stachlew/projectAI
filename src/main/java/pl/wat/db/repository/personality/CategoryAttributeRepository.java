package pl.wat.db.repository.personality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.personality.CategoryAttribute;
import pl.wat.db.domain.personality.PersonalityCategory;

import java.util.List;

public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute, Long> {
    List<CategoryAttribute> findByPersonalityCategory(PersonalityCategory personalityCategory);
}
