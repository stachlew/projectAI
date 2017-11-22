package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
@Table(name = "Martial_Status")
public class MartialStatus extends Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Martial_Status_PK")
    @SequenceGenerator(sequenceName = "Martial_Status_PK", initialValue = 1, allocationSize = 1, name = "Martial_Status_PK")
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
