package pl.wat.db.repository.localization;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.db.domain.localization.City;
import pl.wat.db.domain.localization.Region;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findAllByRegionId(int regionId);
    List<City> findAll();
}
