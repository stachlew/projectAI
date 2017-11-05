package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
@Table(name = "zodiac_sign")
public class ZodiacSign {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zodiac_sign_PK")
    @SequenceGenerator(sequenceName = "zodiac_sign_PK", initialValue = 1, allocationSize = 1, name = "zodiac_sign_PK")
    private int id;

    @Column
    private String description;
}
