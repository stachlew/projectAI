package pl.wat.api.persons;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.wat.logic.dto.personality.MatchForm;
import pl.wat.logic.service.personality.PersonalityService;

@RestController
@RequestMapping("/api/person-fit")
public class PersonFitController {
    @Autowired
    PersonalityService personalityService;

    //zapisywanie formularza dopasowania
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/saveMatchForm",method = RequestMethod.POST)
    public @ResponseBody
    MatchForm saveMatchForm(Authentication auth, @RequestBody MatchForm request){
       return personalityService.saveMatchForm(request);
    }
}
