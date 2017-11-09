package pl.wat.logic.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.config.PasswordGenerator;

import pl.wat.db.repository.user.UserRepository;

import pl.wat.logic.service.utils.TransformService;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.profile.ProfileService;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private TransformService transfer;



    public int countActiveUsers (){
        return userRepository.countUserByAccountInfo_Active(true);
    }


    //TO DO hash password
    public UserDTO createNewUser(UserDTO newUser){
        newUser.setPassword(PasswordGenerator.hashPassword(newUser.getPassword()));
        return transfer.toSimpleDto(userRepository.save(transfer.toEntity(newUser)));
    }

}
