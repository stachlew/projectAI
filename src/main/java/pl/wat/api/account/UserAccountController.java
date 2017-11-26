package pl.wat.api.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.wat.api.util.BaseController;
import pl.wat.db.domain.user.User;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.user.UserService;
import pl.wat.logic.service.utils.PasswordChangeRequest;
import pl.wat.logic.service.utils.RestResponse;

@RestController
@RequestMapping("/api/account")
public class UserAccountController extends BaseController {
    @Autowired
    private UserService userService;

    //Rejestracja nowego konta
    @RequestMapping(value = "/createNewUser",method = RequestMethod.POST)
    @ResponseBody
    RestResponse<UserDTO> createNewUser(@RequestBody UserDTO newUser){
        return userService.createNewUser(newUser);
    }

    //Pobranie danych o koncie
    @PreAuthorize("hasRole('USER') or hasRole('MANAGER')")
    @RequestMapping(value = "/getAccountInfo",method = RequestMethod.GET)
    @ResponseBody UserDTO getUserInfo(Authentication auth){
        Long id =  getLoggerUser(auth).getId();
        return userService.getUserInfo(id);
    }

    //Zmiana hasła
    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER') or hasRole('MANAGER')")
    @ResponseBody Boolean changePassword(Authentication auth, @RequestBody PasswordChangeRequest passwords){
        UserDTO user = getLoggerUser(auth);
        if(passwords!=null){
            return userService.changePassword(user,passwords.oldPass,passwords.newPass);
        }else {
            return false;
        }

    }
}
