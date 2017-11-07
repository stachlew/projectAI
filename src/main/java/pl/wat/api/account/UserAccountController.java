package pl.wat.api.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    //Zmiana hasła
}
