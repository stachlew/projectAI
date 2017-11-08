package pl.wat.db.domain.speeddate;


import pl.wat.db.domain.user.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Speeddate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Speeddate_PK")
    @SequenceGenerator(sequenceName = "Speeddate_PK", initialValue = 1, allocationSize = 1, name = "Speeddate_PK")
    private int id;

    @Column
    private Timestamp dateStart;


    @Column
    private int capacity;

    @Column(length = 1000)
    private String title;

    @Column(length = 4000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "localozation_id")
    private Localization localization;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

    @OneToMany(mappedBy = "speeddate")
    @Basic(fetch = FetchType.LAZY)
    private List<Participant> participantList;


}
