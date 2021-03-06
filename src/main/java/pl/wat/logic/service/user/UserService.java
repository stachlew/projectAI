package pl.wat.logic.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wat.config.Constants;
import pl.wat.config.PasswordGenerator;

import pl.wat.db.domain.user.Authority;
import pl.wat.db.domain.user.AuthorityName;
import pl.wat.db.domain.user.User;
import pl.wat.db.repository.personality.UserPersonalityAttributeRepository;
import pl.wat.db.repository.user.AuthorityRepository;
import pl.wat.db.repository.user.UserRepository;

import pl.wat.logic.service.utils.RestResponse;
import pl.wat.logic.service.utils.TransformService;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.profile.ProfileService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPersonalityAttributeRepository userPersonalityAttributeRepository;

    @Autowired
    private TransformService transfer;

    @Autowired
    private AuthorityRepository authorityRepository;



    public int countActiveUsers (){
        return userRepository.countUserByEnabledTrue();
    }


    //TO DO hash password
    public RestResponse<UserDTO> createNewUser(UserDTO newUser){
        RestResponse<UserDTO> response = new RestResponse<>();
        User oldUser = userRepository.findByUsername(newUser.getUsername());
        if(oldUser == null){
            newUser.setPassword(PasswordGenerator.hashPassword(newUser.getPassword()));
            newUser.setMan(Constants.SEX_MAN.equals(newUser.getSex()));
            User entity = transfer.toEntity(newUser);
            entity.setLastpassres(new Date());
            entity.setAccountCreateDate(new Date());
            entity.setEnabled(true);
            List<Authority> authorities = new LinkedList<>();
            if(Constants.USER_TYPE.equals(newUser.getUserType())){
                authorities.add(authorityRepository.findFirstByName(AuthorityName.ROLE_USER));
                entity.setAuthorities(authorities);
                response.status = 200;
                response.value = transfer.toSimpleDto(userRepository.save(entity));
            }
            else if (Constants.MANAGER_TYPE.equals(newUser.getUserType())){
                authorities.add(authorityRepository.findFirstByName(AuthorityName.ROLE_MANAGER));
                entity.setAuthorities(authorities);
                response.status = 200;
                response.value = transfer.toSimpleDto(userRepository.save(entity));
            }
            else {
                response.status = 400;
                response.error = "Błędny typ użytkownika!";
            }

        }else {
            response.status = 400;
            response.error = "Login jest już zajęty!";
        }
        return response;
    }

    public UserDTO getUserInfo(Long idUser) {
        User user = userRepository.getOne(idUser);
        return transfer.toDto(user);
    }

    @Transactional(readOnly = true)
    public UserDTO getUserByLogin(String login){
        User fetched = userRepository.findByUsername(login);
        return transfer.toDto(fetched);
    }

    public boolean changePassword(UserDTO user, String oldPass, String newPass) {
        if(user.getPassword()!= null && PasswordGenerator.comparePassword(user.getPassword(),oldPass)){
            String newHash = PasswordGenerator.hashPassword(newPass);
            User toUpdate = userRepository.findOne(user.getId());
            toUpdate.setPassword(newHash);
            if(userRepository.save(toUpdate)!=null){
                return true;
            }
        }
        return false;
    }

    public boolean changeLocalization(UserDTO loggedUser, UserDTO formUser) {
        User toUpdate = userRepository.findOne(loggedUser.getId());
        toUpdate.setCity(transfer.toEntity(formUser.getCity()));
        if(userRepository.save(toUpdate)!=null){
            return true;
        }
        return false;
    }

    public boolean saveUserDetailChanges(UserDTO loggedUser, UserDTO formUser) {
        UserDTO toUpdate = transfer.toDto(userRepository.findOne(loggedUser.getId()));
        if(toUpdate != null){
            toUpdate.setHeight(formUser.getHeight());
            toUpdate.setProfession(formUser.getProfession());
            toUpdate.setDescription(formUser.getDescription());

            toUpdate.setEducation(formUser.getEducation());
            toUpdate.setMartialStatus(formUser.getMartialStatus());
            toUpdate.setKids(formUser.getKids());
            toUpdate.setReligion(formUser.getReligion());
            toUpdate.setSmoking(formUser.getSmoking());
            toUpdate.setDrinking(formUser.getDrinking());
            toUpdate.setZodiacSign(formUser.getZodiacSign());
            toUpdate.setFigure(formUser.getFigure());
            toUpdate.setHairColor(formUser.getHairColor());
            toUpdate.setEyeColor(formUser.getEyeColor());
            User toSave = transfer.toEntity(toUpdate);
            if(userRepository.save(toSave) != null){
                return true;
            }
        }
        return false;
    }
}
