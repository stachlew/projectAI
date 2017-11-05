package pl.wat.db.domain.user.profile.attributes;


import javax.persistence.*;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Region_PK")
    @SequenceGenerator(sequenceName = "Region_PK", initialValue = 1, allocationSize = 1, name = "Region_PK")
    private int id;

    @Column
    private String description;
}
