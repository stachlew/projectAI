package pl.wat.db.domain.personality;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "pers_category")
public class PersonalityCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_category_seq")
    @SequenceGenerator(sequenceName = "pers_category_seq", initialValue = 1, allocationSize = 1, name = "pers_category_seq")
    private int id;

    @Column(length = 500)
    @NotNull
    private String description;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<CategoryAttribute> attributes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CategoryAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CategoryAttribute> attributes) {
        this.attributes = attributes;
    }
}
