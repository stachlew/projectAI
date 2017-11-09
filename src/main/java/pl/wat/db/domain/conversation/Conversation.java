package pl.wat.db.domain.conversation;


import pl.wat.db.domain.user.User;

import javax.persistence.*;
import java.util.LinkedList;
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

    public Conversation() {
    }

    public Conversation(User memberOne, User memberTwo) {
        this.memberOne = memberOne;
        this.memberTwo = memberTwo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getMemberOne() {
        return memberOne;
    }

    public void setMemberOne(User memberOne) {
        this.memberOne = memberOne;
    }

    public User getMemberTwo() {
        return memberTwo;
    }

    public void setMemberTwo(User memberTwo) {
        this.memberTwo = memberTwo;
    }

}
