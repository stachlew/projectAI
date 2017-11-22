package pl.wat.logic.dto.personality;

import pl.wat.logic.dto.user.UserDTO;

public class UserPersonalityAttributeDTO {

    private Long id;
    private UserDTO user;
    private CategoryAttributeDTO categoryAttribute;
    private String answer;
    private String partnerAnswer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public CategoryAttributeDTO getCategoryAttribute() {
        return categoryAttribute;
    }

    public void setCategoryAttribute(CategoryAttributeDTO categoryAttribute) {
        this.categoryAttribute = categoryAttribute;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPartnerAnswer() {
        return partnerAnswer;
    }

    public void setPartnerAnswer(String partnerAnswer) {
        this.partnerAnswer = partnerAnswer;
    }
}
