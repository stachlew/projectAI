package pl.wat.logic.domainServices.user.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.db.domain.user.profile.attributes.Region;
import pl.wat.db.repository.user.profile.attributes.RegionRepository;

import java.util.List;

@Service
public class AttributesServices {
    @Autowired
    RegionRepository regionRepository;

    public List<Region> getAllRegion(){
        return regionRepository.findAll();
    }
}
