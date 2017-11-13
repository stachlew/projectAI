package pl.wat.logic.service.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wat.db.domain.localization.City;
import pl.wat.db.domain.localization.Region;
import pl.wat.db.repository.localization.CityRepository;
import pl.wat.db.repository.localization.RegionRepository;
import pl.wat.logic.dto.localization.CityDTO;
import pl.wat.logic.dto.localization.RegionDTO;
import pl.wat.logic.service.utils.TransformService;

import java.util.LinkedList;
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
    @Autowired
    CityRepository cityRepository;
    @Autowired
    TransformService transformService;

    public List<RegionDTO> getAllRegion(){
        LinkedList<RegionDTO> dtoList = new LinkedList<>();
        regionRepository.findAll().forEach(region -> {
            dtoList.add(transformService.toDTO(region));
        });
        return dtoList;
    }

    public List<CityDTO> getCityByRegion(RegionDTO region){
        List<City> fetched = cityRepository.findAllByRegionId(region.getId());
        List<CityDTO> dtoList = new LinkedList<>();
        fetched.forEach(city->dtoList.add(transformService.toDTO(city)));
        return dtoList;
    }
}
