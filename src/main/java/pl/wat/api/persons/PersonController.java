package pl.wat.api.persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.wat.logic.dto.profile.ProfileSearchDTO;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.personality.PersonalityService;
import pl.wat.logic.service.utils.PageResponse;
import pl.wat.logic.service.utils.UtilService;



@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonalityService personalityService;
    @Autowired
    UtilService utilService;

    @RequestMapping(value = "/getProfilesList",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public PageResponse<UserDTO> getProfilesList(Authentication auth, @RequestBody ProfileSearchDTO filter){

        Long userId = this.utilService.getUserId(auth);

        filter.setId(userId);
        PageResponse<UserDTO> response = new PageResponse<>();

        response.value = personalityService.getProfilesList(filter);
        response.elementsCount = filter.countElements;
        response.pageNo = filter.pageNo;
        response.pageCount = filter.countPage;
        return response;
    }

}
