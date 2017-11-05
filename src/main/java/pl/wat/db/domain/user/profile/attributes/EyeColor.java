package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
@Table(name = "eye_color")
public class EyeColor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eye_color_PK")
    @SequenceGenerator(sequenceName = "eye_color_PK", initialValue = 1, allocationSize = 1, name = "eye_color_PK")
    private int id;

    @Column
    private String description;
}
