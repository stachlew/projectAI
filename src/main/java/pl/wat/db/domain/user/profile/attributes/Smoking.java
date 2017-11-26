package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
public class Smoking extends Dictionary{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Smoking_PK")
    @SequenceGenerator(sequenceName = "Smoking_PK", initialValue = 1, allocationSize = 1, name = "Smoking_PK")
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
