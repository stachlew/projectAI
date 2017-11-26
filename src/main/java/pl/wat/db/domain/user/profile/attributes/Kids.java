package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.*;

@Entity
public class Kids extends Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Kids_PK")
    @SequenceGenerator(sequenceName = "Kids_PK", initialValue = 1, allocationSize = 1, name = "Kids_PK")
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
