package pl.wat.logic.dto.conversation;

import pl.wat.logic.dto.user.UserDTO;

public class ConversationDTO {
    private int id;
    private UserDTO memberOne;
    private UserDTO memberTwo;
    private UserDTO secondPerson;

    public ConversationDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getMemberOne() {
        return memberOne;
    }

    public void setMemberOne(UserDTO memberOne) {
        this.memberOne = memberOne;
    }

    public UserDTO getMemberTwo() {
        return memberTwo;
    }

    public void setMemberTwo(UserDTO memberTwo) {
        this.memberTwo = memberTwo;
    }

    public UserDTO getSecondPerson() {
        return secondPerson;
    }

    public void setSecondPerson(UserDTO secondPerson) {
        this.secondPerson = secondPerson;
    }
}
