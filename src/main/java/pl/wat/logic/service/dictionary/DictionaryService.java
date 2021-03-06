package pl.wat.logic.service.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wat.db.domain.localization.City;
import pl.wat.db.domain.localization.Region;
import pl.wat.db.domain.user.profile.attributes.EyeColor;
import pl.wat.db.domain.user.profile.attributes.ZodiacSign;
import pl.wat.db.repository.localization.CityRepository;
import pl.wat.db.repository.localization.RegionRepository;
import pl.wat.db.repository.user.profile.attributes.*;
import pl.wat.logic.dto.dictionary.DictionaryDTOLists;
import pl.wat.logic.dto.dictionary.SimpleDictionaryDTO;
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
    EducationRepository educationRepository;
    @Autowired
    EyeColorRepository eyeColorRepository;
    @Autowired
    FigureRepository figureRepository;
    @Autowired
    HairColorRepository hairColorRepository;
    @Autowired
    MartialStatusRepository martialStatusRepository;
    @Autowired
    ReligionRepository religionRepository;
    @Autowired
    ZodiacSignRepository zodiacSignRepository;
    @Autowired
    DrinkingRepository drinkingRepository;
    @Autowired
    SmokingRepository smokingRepository;
    @Autowired
    KidsRepository kidsRepository;
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

    private List<SimpleDictionaryDTO> getAllEducation(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        educationRepository.findAll().forEach(education -> {
            dtoList.add(transformService.toDTO(education));
        });
        return dtoList;
    }

    private List<SimpleDictionaryDTO> getAllEyeColor(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        eyeColorRepository.findAll().forEach(eyeColor -> dtoList.add(transformService.toDTO(eyeColor)));
        return dtoList;
    }

    private List<SimpleDictionaryDTO> getAllFigure(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        figureRepository.findAll().forEach(figure -> dtoList.add(transformService.toDTO(figure)));
        return dtoList;
    }

    private List<SimpleDictionaryDTO> getAllHairColor(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        hairColorRepository.findAll().forEach(hairColor -> dtoList.add(transformService.toDTO(hairColor)));
        return dtoList;
    }

    private List<SimpleDictionaryDTO> getAllMartialStatus(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        martialStatusRepository.findAll().forEach(martialStatus -> dtoList.add(transformService.toDTO(martialStatus)));
        return dtoList;
    }

    private List<SimpleDictionaryDTO> getAllReligion(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        religionRepository.findAll().forEach(religion -> dtoList.add(transformService.toDTO(religion)));
        return dtoList;
    }

    private List<SimpleDictionaryDTO> getAllZodiacSign(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        zodiacSignRepository.findAll().forEach(zodiacSign -> dtoList.add(transformService.toDTO(zodiacSign)));
        return dtoList;
    }

    private List<SimpleDictionaryDTO> getAllKids(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        kidsRepository.findAll().forEach(kid -> dtoList.add(transformService.toDTO(kid)));
        return dtoList;
    }

    private List<SimpleDictionaryDTO> getAllSmoking(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        smokingRepository.findAll().forEach(smoking -> dtoList.add(transformService.toDTO(smoking)));
        return dtoList;
    }

    private List<SimpleDictionaryDTO> getAllDrinking(){
        LinkedList<SimpleDictionaryDTO> dtoList = new LinkedList<>();
        drinkingRepository.findAll().forEach(drinking -> dtoList.add(transformService.toDTO(drinking)));
        return dtoList;
    }

    public DictionaryDTOLists getAllUserDictionary(){
        DictionaryDTOLists dictionaryDTOLists = new DictionaryDTOLists();
        dictionaryDTOLists.setEducationList((this.getAllEducation()));
        dictionaryDTOLists.setEyeColorList(this.getAllEyeColor());
        dictionaryDTOLists.setFigureList(this.getAllFigure());
        dictionaryDTOLists.setHairColorList(this.getAllHairColor());
        dictionaryDTOLists.setMartialStatusList(this.getAllMartialStatus());
        dictionaryDTOLists.setReligionList(this.getAllReligion());
        dictionaryDTOLists.setZodiacSignList(this.getAllZodiacSign());
        dictionaryDTOLists.setDrinkingList(this.getAllDrinking());
        dictionaryDTOLists.setSmokingList(this.getAllSmoking());
        dictionaryDTOLists.setKidsList(this.getAllKids());
        return dictionaryDTOLists;
    }
}
