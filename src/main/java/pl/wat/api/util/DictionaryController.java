package pl.wat.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.db.domain.user.profile.attributes.Region;
import pl.wat.logic.domainServices.user.profile.AttributesServices;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    @Autowired
    AttributesServices attributesServices;
    //slownik wojewodztw
    @RequestMapping(value = "/getRegions",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public List<Region> getRegions(Authentication auth){
        return attributesServices.getAllRegion();
    }

    //slownik miast

}
