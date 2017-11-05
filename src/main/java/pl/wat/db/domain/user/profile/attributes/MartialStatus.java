package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
@Table(name = "Martial_Status")
public class MartialStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Martial_Status_PK")
    @SequenceGenerator(sequenceName = "Martial_Status_PK", initialValue = 1, allocationSize = 1, name = "Martial_Status_PK")
    private int id;

    @Column
    private String description;
}
