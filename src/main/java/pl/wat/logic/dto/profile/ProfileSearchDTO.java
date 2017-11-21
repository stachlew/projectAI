package pl.wat.logic.dto.profile;

import pl.wat.logic.dto.localization.CityDTO;
import pl.wat.logic.dto.localization.RegionDTO;

public class ProfileSearchDTO {

    //Pola na razie dostępne na froncie jako pola wyszukiwania osób
    public RegionDTO region;
    public CityDTO city;
    public int ageFrom;
    public int ageTo;
    public int pageNo;
    public int pageSize;

}
