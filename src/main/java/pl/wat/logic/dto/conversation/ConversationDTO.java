package pl.wat.logic.dto.conversation;

import pl.wat.logic.dto.user.UserDTO;

public class ConversationDTO {
    private Long id;
    private UserDTO memberOne;
    private UserDTO memberTwo;
    private UserDTO secondPerson;
    private PrivateMessageDTO lastMessage;

    public ConversationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public PrivateMessageDTO getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(PrivateMessageDTO lastMessage) {
        this.lastMessage = lastMessage;
    }
}
