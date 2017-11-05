package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
public class Figure {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Figure_PK")
    @SequenceGenerator(sequenceName = "Figure_PK", initialValue = 1, allocationSize = 1, name = "Figure_PK")
    private int id;

    @Column
    private String description;
}

