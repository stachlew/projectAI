package pl.wat.logic.service.personality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import pl.wat.db.domain.personality.CategoryAttribute;
import pl.wat.db.domain.personality.Match;
import pl.wat.db.domain.personality.PersonalityCategory;
import pl.wat.db.domain.personality.UserPersonalityAttribute;
import pl.wat.db.domain.user.User;
import pl.wat.db.repository.personality.CategoryAttributeRepository;
import pl.wat.db.repository.personality.PersonalityCategoryRepository;
import pl.wat.db.repository.personality.UserPersonalityAttributeRepository;
import pl.wat.db.repository.user.UserRepository;
import pl.wat.logic.dto.personality.MatchForm;
import pl.wat.logic.dto.personality.UserPersonalityAttributeDTO;
import pl.wat.logic.dto.profile.ProfileSearchDTO;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.utils.TransformService;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
public class PersonalityService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TransformService transformService;
    @Autowired
    UserPersonalityAttributeRepository userPersonalityAttributeRepository;
    @Autowired
    CategoryAttributeRepository categoryAttributeRepository;
    @Autowired
    PersonalityCategoryRepository personalityCategoryRepository;

    public List<UserDTO> getProfilesList(ProfileSearchDTO profileSearchDTO){
        LinkedList<UserDTO> userDTOList = new LinkedList<>();

        Slice<User> usersByFilter = userRepository.findUsersByFilter(profileSearchDTO, new PageRequest(profileSearchDTO.pageNo-1, profileSearchDTO.pageSize));
        usersByFilter.getContent().forEach(user -> userDTOList.add(transformService.toDto(user)));
        userDTOList.forEach(userDTO -> {
            List<Object[]> result = userPersonalityAttributeRepository.findMatchUserIdOneToUserIdTwo(profileSearchDTO.getId(),userDTO.getId());
            List<Match> matchList = new LinkedList<>();
            result.forEach(objects -> matchList.add(new Match((String)objects[0],(BigDecimal) objects[1])));
            userDTO.setMatchList(matchList);
        });
        return userDTOList;
    }

    public MatchForm getMatchForm(Long userId) {
        User user = userRepository.findOne(userId);
        if (user != null) {
            List<UserPersonalityAttribute> firstByUser = userPersonalityAttributeRepository.findFirstByUser(user);
            if(firstByUser!=null && !firstByUser.isEmpty()){
                return getMatchFormForUser(user);
            }
            else {
                return getMatchFormEmpty(user);
            }
        }
        else
            return null;
    }

    private MatchForm getMatchFormEmpty(User user) {
        MatchForm matchForm = new MatchForm();
        matchForm.setUserDTO(transformService.toDto(user));

        List<PersonalityCategory> personalityCategories = personalityCategoryRepository.findAll();

        List<UserPersonalityAttributeDTO> userPersonalityAttributeDTOCharacter = new LinkedList<>();
        List<CategoryAttribute> categoryAttributesCharacter = categoryAttributeRepository.findByPersonalityCategory(personalityCategories.get(0));
        categoryAttributesCharacter.forEach(categoryAttribute -> {
            UserPersonalityAttributeDTO userPersonalityAttributeDTO = new UserPersonalityAttributeDTO();
            userPersonalityAttributeDTO.setCategoryAttribute(transformService.toDTO(categoryAttribute));
            userPersonalityAttributeDTO.setUser(transformService.toDto(user));
            userPersonalityAttributeDTOCharacter.add(userPersonalityAttributeDTO);
        });
        List<UserPersonalityAttributeDTO> userPersonalityAttributeDTOPersonality = new LinkedList<>();
        List<CategoryAttribute> categoryAttributesPersonality = categoryAttributeRepository.findByPersonalityCategory(personalityCategories.get(1));
        categoryAttributesPersonality.forEach(categoryAttribute -> {
            UserPersonalityAttributeDTO userPersonalityAttributeDTO = new UserPersonalityAttributeDTO();
            userPersonalityAttributeDTO.setCategoryAttribute(transformService.toDTO(categoryAttribute));
            userPersonalityAttributeDTO.setUser(transformService.toDto(user));
            userPersonalityAttributeDTOPersonality.add(userPersonalityAttributeDTO);
        });

        List<UserPersonalityAttributeDTO> userPersonalityAttributeDTOFreeTime = new LinkedList<>();
        List<CategoryAttribute> categoryAttributesFreeTime = categoryAttributeRepository.findByPersonalityCategory(personalityCategories.get(2));
        categoryAttributesFreeTime.forEach(categoryAttribute -> {
            UserPersonalityAttributeDTO userPersonalityAttributeDTO = new UserPersonalityAttributeDTO();
            userPersonalityAttributeDTO.setCategoryAttribute(transformService.toDTO(categoryAttribute));
            userPersonalityAttributeDTO.setUser(transformService.toDto(user));
            userPersonalityAttributeDTOFreeTime.add(userPersonalityAttributeDTO);
        });

        matchForm.setCharacterList(userPersonalityAttributeDTOCharacter);
        matchForm.setPersonalityList(userPersonalityAttributeDTOPersonality);
        matchForm.setFreeTimeList(userPersonalityAttributeDTOFreeTime);

        return matchForm;
        
    }

    private MatchForm getMatchFormForUser(User user) {
        List<PersonalityCategory> personalityCategories = personalityCategoryRepository.findAll();
        MatchForm matchForm = new MatchForm();
        matchForm.setUserDTO(transformService.toDto(user));
        matchForm.setCharacterList(transformService.toDTO(userPersonalityAttributeRepository.findByUserAndCategoryAttribute_PersonalityCategory(user,personalityCategories.get(0))));
        matchForm.setPersonalityList(transformService.toDTO(userPersonalityAttributeRepository.findByUserAndCategoryAttribute_PersonalityCategory(user,personalityCategories.get(1))));
        matchForm.setFreeTimeList(transformService.toDTO(userPersonalityAttributeRepository.findByUserAndCategoryAttribute_PersonalityCategory(user,personalityCategories.get(2))));
        return matchForm;
    }

    public MatchForm saveMatchForm(MatchForm matchForm){
        matchForm.getCharacterList().forEach(userPersonalityAttributeDTO -> {
            UserPersonalityAttribute userPersonalityAttribute = transformService.toEntity(userPersonalityAttributeDTO);
            userPersonalityAttributeRepository.save(userPersonalityAttribute);
        });
        matchForm.getPersonalityList().forEach(userPersonalityAttributeDTO -> {
            UserPersonalityAttribute userPersonalityAttribute = transformService.toEntity(userPersonalityAttributeDTO);
            userPersonalityAttributeRepository.save(userPersonalityAttribute);
        });
        matchForm.getFreeTimeList().forEach(userPersonalityAttributeDTO -> {
            UserPersonalityAttribute userPersonalityAttribute = transformService.toEntity(userPersonalityAttributeDTO);
            userPersonalityAttributeRepository.save(userPersonalityAttribute);
        });
        return getMatchFormForUser(transformService.toEntity(matchForm.getUserDTO()));
    }
}
