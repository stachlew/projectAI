package pl.wat.db.domain.conversation;

import pl.wat.db.domain.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class PrivateMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PrivateMessage_PK")
    @SequenceGenerator(sequenceName = "PrivateMessage_PK", initialValue = 1, allocationSize = 1, name = "PrivateMessage_PK")
    private int id;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    @Column
    private Timestamp sendDate;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column
    private String textMessage;

}
