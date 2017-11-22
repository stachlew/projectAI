package pl.wat.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import pl.wat.logic.dto.dictionary.SimpleDictionaryDTO;
import pl.wat.logic.dto.localization.CityDTO;
import pl.wat.logic.dto.localization.RegionDTO;
import pl.wat.logic.service.dictionary.DictionaryService;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    //slownik wojewodztw
    @RequestMapping(value = "/getRegions", method = RequestMethod.GET)
    @ResponseBody
    public List<RegionDTO> getRegions(Authentication auth) {
        return dictionaryService.getAllRegion();
    }

    //slownik miast
    @RequestMapping(value = "/getCities", method = RequestMethod.POST)
    @ResponseBody
    public List<CityDTO> getCity(Authentication auth, @RequestBody RegionDTO region) {
        return dictionaryService.getCityByRegion(region);
    }




}
