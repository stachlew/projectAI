package pl.wat.db.domain.personality;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Klasa PersonalityCategory.
 * Klasa opisująca kategorie osobowości.
 * Każda z kategorii posiada swoją listę cech.
 */
@Entity
@Table(name = "PERSONALITY_CATEGORY")
public class PersonalityCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONALITY_CATEGORY_PK")
    @SequenceGenerator(sequenceName = "PERSONALITY_CATEGORY_PK", initialValue = 1, allocationSize = 1, name = "PERSONALITY_CATEGORY_PK")
    private Long id;

    @Column(length = 500)
    @NotNull
    private String description;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<CategoryAttribute> attributes;

    @Column
    private int amount;

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

    public List<CategoryAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CategoryAttribute> attributes) {
        this.attributes = attributes;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
