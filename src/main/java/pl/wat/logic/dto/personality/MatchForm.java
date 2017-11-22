package pl.wat.logic.dto.personality;

import pl.wat.logic.dto.user.UserDTO;

import java.util.List;

public class MatchForm {
    UserDTO userDTO;
    List<UserPersonalityAttributeDTO> characterList;
    List<UserPersonalityAttributeDTO> personalityList;
    List<UserPersonalityAttributeDTO> freeTimeList;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<UserPersonalityAttributeDTO> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<UserPersonalityAttributeDTO> characterList) {
        this.characterList = characterList;
    }

    public List<UserPersonalityAttributeDTO> getPersonalityList() {
        return personalityList;
    }

    public void setPersonalityList(List<UserPersonalityAttributeDTO> personalityList) {
        this.personalityList = personalityList;
    }

    public List<UserPersonalityAttributeDTO> getFreeTimeList() {
        return freeTimeList;
    }

    public void setFreeTimeList(List<UserPersonalityAttributeDTO> freeTimeList) {
        this.freeTimeList = freeTimeList;
    }
}
