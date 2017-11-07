package pl.wat.logic.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.config.PasswordGenerator;
import pl.wat.db.domain.user.User;
import pl.wat.db.repository.user.UserRepository;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.profile.ProfileService;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileService profileService;

    UserDTO toDto(User entity){
        if(entity!=null){
            UserDTO dto = new UserDTO();
            dto.setUsername(entity.getUsername());
            dto.setPassword(entity.getPassword());
            dto.setFirstname(entity.getFirstname());
            dto.setLastname(entity.getLastname());
            dto.setEmail(entity.getEmail());
            dto.setAccountCreateDate(entity.getAccountInfo().getAccountCreateDate()); //WINA Embedded
            dto.setLastLogoutDate(entity.getAccountInfo().getLastLogoutDate());
            dto.setLastpassres(entity.getLastpassres());
            dto.setActive(entity.getAccountInfo().isActive());
            dto.setEnabled(entity.getEnabled());
            dto.setProfile(profileService.toDTO(entity.getProfile()));
            dto.setAuthorities(entity.getAuthorities());
            return dto;
        }else {
            return null;
        }
    }

    User toEntity(UserDTO dto){
        if(dto !=null){
            User entity = new User();
            entity.setUsername(dto.getUsername());
            entity.setPassword(dto.getPassword());
            entity.setFirstname(dto.getFirstname());
            entity.setLastname(dto.getLastname());
            // ... itd
            return entity;
        }else {
            return null;
        }
    }



    public int countActiveUsers (){
        return userRepository.countUserByAccountInfo_Active(true);
    }


    //TO DO hash password
    public UserDTO createNewUser(UserDTO newUser){
        newUser.setPassword(PasswordGenerator.hashPassword(newUser.getPassword()));
        return toDto(userRepository.save(toEntity(newUser)));
    }

}
