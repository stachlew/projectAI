package pl.wat.db.domain.speeddate;

import pl.wat.db.domain.user.User;

import javax.persistence.*;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Participant_PK")
    @SequenceGenerator(sequenceName = "Participant_PK", initialValue = 1, allocationSize = 1, name = "Participant_PK")
    private int id;

    @ManyToOne
    @JoinColumn(name = "speeddate_id")
    private Speeddate speeddate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
