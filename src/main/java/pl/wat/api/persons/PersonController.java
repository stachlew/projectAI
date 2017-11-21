package pl.wat.api.persons;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.wat.logic.dto.profile.ProfileSearchDTO;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.utils.PageResponse;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @RequestMapping(value = "/getProfilesList",method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<UserDTO> getProfilesList(Authentication auth, @RequestBody ProfileSearchDTO filter){

        PageResponse<UserDTO> response = new PageResponse<>();
        response.value = null;
        response.elementsCount = 15;
        response.pageNo = filter.pageNo;
        response.pageCount = 2;
        return response;
    }

}
