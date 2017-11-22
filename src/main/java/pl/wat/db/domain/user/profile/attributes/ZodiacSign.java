package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
@Table(name = "zodiac_sign")
public class ZodiacSign extends Dictionary{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zodiac_sign_PK")
    @SequenceGenerator(sequenceName = "zodiac_sign_PK", initialValue = 1, allocationSize = 1, name = "zodiac_sign_PK")
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
