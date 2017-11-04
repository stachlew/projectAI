package pl.wat.db.domain.personality;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "PERSONALITY_CATEGORY")
public class PersonalityCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONALITY_CATEGORY_PK")
    @SequenceGenerator(sequenceName = "PERSONALITY_CATEGORY_PK", initialValue = 1, allocationSize = 1, name = "PERSONALITY_CATEGORY_PK")
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
