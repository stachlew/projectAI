package pl.wat.api.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wat.db.domain.user.User;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.user.UserService;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {
    @Autowired
    private UserService userService;

    //Rejestracja nowego konta
    @RequestMapping(value = "/createNewUser",method = RequestMethod.POST)
    @ResponseBody UserDTO createNewUser(@RequestBody UserDTO newUser){
        return userService.createNewUser(newUser);
    }
    //Pobranie danych o koncie
    @RequestMapping(value = "/getAccountInfo",method = RequestMethod.GET)
    @ResponseBody UserDTO getUserInfo(int idUser){
        return userService.getUserInfo(idUser);
    }

    //Zmiana hasła
    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    @ResponseBody UserDTO changePassword(@RequestBody User user,String newPass){
        return userService.changePassword(user,newPass);
    }
}
