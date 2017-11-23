package pl.wat.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.user.UserService;

public class BaseController {

    @Autowired
    UserService userService;

    public UserDTO getLoggerUser(Authentication auth){
        return userService.getUserByLogin(auth.getName());
    }
}
