package pl.wat.logic.dtoServices.user;

import pl.wat.db.domain.user.User;
import pl.wat.logic.dto.user.UserRegistered;

public class UserServicesDTO {
    public User createUserFromUserRegistred(UserRegistered userRegistered){
        return new User(userRegistered.getUsername(), userRegistered.getPassword(), userRegistered.getFirstname(), userRegistered.getLastname(), userRegistered.getEmail());
    }
}
