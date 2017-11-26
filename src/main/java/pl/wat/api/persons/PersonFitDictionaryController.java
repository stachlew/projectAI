package pl.wat.api.persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.db.domain.user.Authority;
import pl.wat.logic.dto.dictionary.DictionaryDTOLists;
import pl.wat.logic.dto.dictionary.SimpleDictionaryDTO;
import pl.wat.logic.dto.personality.MatchForm;
import pl.wat.logic.service.dictionary.DictionaryService;
import pl.wat.logic.service.personality.PersonalityService;
import pl.wat.logic.service.utils.UtilService;

import java.util.List;

@RestController
@RequestMapping("/api/person-fit-dictionary")
public class PersonFitDictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    PersonalityService personalityService;

    @Autowired
    UtilService utilService;
    //slowniki usera
    @RequestMapping(value = "/getAllUserDictionary",method = RequestMethod.GET)
    @ResponseBody
    public DictionaryDTOLists getAllUserDictionary(){
        return dictionaryService.getAllUserDictionary();
    }

    @RequestMapping(value = "/getMatchForm",method = RequestMethod.GET)
    @ResponseBody
    public MatchForm getMatchForm(Authentication authority){
        Long userId =utilService.getUserId(authority);
        return personalityService.getMatchForm(userId);
    }
}
