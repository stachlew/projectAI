package pl.wat.logic.dto.conversation;

import pl.wat.logic.dto.user.UserDTO;

import java.util.Date;

public class PrivateMessageDTO {

    private int id;
    private ConversationDTO conversation;
    private Date sendDate;
    private UserDTO sender;
    private String textMessage;

    public PrivateMessageDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ConversationDTO getConversation() {
        return conversation;
    }

    public void setConversation(ConversationDTO conversation) {
        this.conversation = conversation;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}
