package pl.wat.db.domain.user.profile.attributes;


import javax.persistence.*;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Education_PK")
    @SequenceGenerator(sequenceName = "Education_PK", initialValue = 1, allocationSize = 1, name = "Education_PK")
    private int id;

    @Column
    private String description;
}
