package pl.wat.db.repository.user.profile.attributes;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.db.domain.user.profile.attributes.Religion;

public interface ReligionRepository extends JpaRepository<Religion, Long> {
}
