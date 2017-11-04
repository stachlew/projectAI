package pl.wat.db.repository.personality;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.personality.CategoryAttribute;

public interface CategoryAttributeRepository extends CrudRepository<CategoryAttribute, Integer> {
}
