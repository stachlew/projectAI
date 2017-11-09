package pl.wat.logic.service.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.db.domain.dictionary.SimpleDictionary;
import pl.wat.db.domain.user.profile.attributes.Region;
import pl.wat.db.repository.user.profile.attributes.RegionRepository;
import pl.wat.logic.dto.dictionary.SimpleDictionaryDTO;

import java.util.List;

@Service
public class DictionaryService {

//    SimpleDictionary toEntity(SimpleDictionaryDTO dto){
//        SimpleDictionary entity = new SimpleDictionary() {
//        }
//    }
//
//    SimpleDictionaryDTO toDTO(SimpleDictionary entity){
//
//    }

    @Autowired
    RegionRepository regionRepository;

    public List<Region> getAllRegion(){
        return regionRepository.findAll();
    }
}
