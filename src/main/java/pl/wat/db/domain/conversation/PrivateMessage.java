package pl.wat.db.domain.conversation;

import org.hibernate.annotations.ColumnDefault;
import pl.wat.db.domain.user.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class PrivateMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PrivateMessage_PK")
    @SequenceGenerator(sequenceName = "PrivateMessage_PK", initialValue = 1, allocationSize = 1, name = "PrivateMessage_PK")
    private int id;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    @Column()
    @ColumnDefault(value = "sysdate")
    private Date sendDate;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column
    private String textMessage;

    public PrivateMessage() {
    }

    public PrivateMessage(Conversation conversation, User sender, String textMessage) {
        this.conversation = conversation;
        this.sender = sender;
        this.textMessage = textMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}
