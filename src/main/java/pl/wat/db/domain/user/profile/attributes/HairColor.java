package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
@Table(name = "hair_color")
public class HairColor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hair_color_PK")
    @SequenceGenerator(sequenceName = "hair_color_PK", initialValue = 1, allocationSize = 1, name = "hair_color_PK")
    private int id;

    @Column
    private String description;
}
