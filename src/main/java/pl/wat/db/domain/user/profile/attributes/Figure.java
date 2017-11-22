package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
public class Figure extends Dictionary{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Figure_PK")
    @SequenceGenerator(sequenceName = "Figure_PK", initialValue = 1, allocationSize = 1, name = "Figure_PK")
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

