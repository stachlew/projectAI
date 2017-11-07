package pl.wat.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.logic.domainServices.user.UserServices;

@RestController
@RequestMapping("/api/util")
public class UtilController {
    @Autowired
    UserServices userServices;

    //Ilu użytkowników aktywnych
    @RequestMapping(value = "/countActiveUsers",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public int getCountActiveUsers(Authentication auth){
        return userServices.countActiveUsers();
    }

}
