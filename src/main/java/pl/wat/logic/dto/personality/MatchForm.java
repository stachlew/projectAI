package pl.wat.logic.dto.personality;

import pl.wat.db.domain.personality.CategoryAttribute;
import pl.wat.logic.dto.user.UserDTO;

import java.util.List;

public class MatchForm {
    UserDTO userDTO;
    List<CategoryAttributeDTO> characterList;
    List<CategoryAttributeDTO> personalityList;
    List<CategoryAttributeDTO> freeTimeList;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<CategoryAttributeDTO> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<CategoryAttributeDTO> characterList) {
        this.characterList = characterList;
    }

    public List<CategoryAttributeDTO> getPersonalityList() {
        return personalityList;
    }

    public void setPersonalityList(List<CategoryAttributeDTO> personalityList) {
        this.personalityList = personalityList;
    }

    public List<CategoryAttributeDTO> getFreeTimeList() {
        return freeTimeList;
    }

    public void setFreeTimeList(List<CategoryAttributeDTO> freeTimeList) {
        this.freeTimeList = freeTimeList;
    }
}
