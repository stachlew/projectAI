package pl.wat.db.repository.user.profile.attributes;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.db.domain.user.profile.attributes.ZodiacSign;

public interface ZodiacSignRepository extends JpaRepository<ZodiacSign, Long> {
}
