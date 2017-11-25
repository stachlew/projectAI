package pl.wat.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.logic.service.user.UserService;

@RestController
@RequestMapping("/api/util")
public class UtilController extends BaseController {
    @Autowired
    UserService userServices;

    //Ilu użytkowników aktywnych
    @RequestMapping(value = "/countActiveUsers",method = RequestMethod.GET)
    @ResponseBody
    public int getCountActiveUsers(Authentication auth){
        return userServices.countActiveUsers();
    }

    @RequestMapping(value = "/my-id",method = RequestMethod.GET)
    @ResponseBody
    public Long getMyId(Authentication auth){
        return getLoggerUser(auth).getId();
    }

}
