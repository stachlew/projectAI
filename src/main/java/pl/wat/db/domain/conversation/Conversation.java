package pl.wat.db.domain.conversation;


import pl.wat.db.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Conversation_PK")
    @SequenceGenerator(sequenceName = "Conversation_PK", initialValue = 1, allocationSize = 1, name = "Conversation_PK")
    private int id;

    @ManyToOne
    @JoinColumn(name = "memberOne_id")
    private User memberOne;

    @ManyToOne
    @JoinColumn(name = "memberTwo_id")
    private User memberTwo;

    @OneToMany(mappedBy = "conversation")
    @Basic(fetch = FetchType.LAZY)
    private List<PrivateMessage> privateMessageList;


}
