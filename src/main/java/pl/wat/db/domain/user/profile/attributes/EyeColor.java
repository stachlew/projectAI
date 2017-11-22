package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
@Table(name = "eye_color")
public class EyeColor extends Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eye_color_PK")
    @SequenceGenerator(sequenceName = "eye_color_PK", initialValue = 1, allocationSize = 1, name = "eye_color_PK")
    private Long id;

    @Column
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
