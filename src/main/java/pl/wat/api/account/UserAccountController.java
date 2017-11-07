package pl.wat.api.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wat.db.domain.DemoClass;
import pl.wat.db.domain.user.User;
import pl.wat.logic.domainServices.user.UserServices;
import pl.wat.logic.dto.user.UserRegistered;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {
    @Autowired
    private UserServices userServices;

    //Rejestracja nowego konta
    @RequestMapping(value = "/createNewUser",method = RequestMethod.POST)
    @ResponseBody User createNewUser(@RequestBody UserRegistered newUser){
        return userServices.createNewUser(newUser);
    }
    //Pobranie danych o koncie

    //Zmiana hasła
}
