package pl.wat.logic.domainServices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.config.PasswordGenerator;
import pl.wat.db.domain.user.User;
import pl.wat.db.repository.user.UserRepository;
import pl.wat.logic.dto.user.UserRegistered;
import pl.wat.logic.dtoServices.user.UserServicesDTO;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserServicesDTO userServicesDTO;


    public int countActiveUsers (){
        return userRepository.countUserByAccountInfo_Active(true);
    }

    //TO DO hash password
    public User createNewUser(UserRegistered newUser){
        newUser.setPassword(PasswordGenerator.hashPassword(newUser.getPassword()));
        User user = userServicesDTO.createUserFromUserRegistred(newUser);
        return userRepository.save(user);
    }
}
