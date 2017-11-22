package pl.wat.db.repository.localization;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.db.domain.localization.Region;


public interface RegionRepository extends JpaRepository<Region, Long> {
}
