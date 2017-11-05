package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
public class Religion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Religion_PK")
    @SequenceGenerator(sequenceName = "Religion_PK", initialValue = 1, allocationSize = 1, name = "Religion_PK")
    private int id;

    @Column
    private String description;
}
