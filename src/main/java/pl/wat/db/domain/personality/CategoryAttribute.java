package pl.wat.db.domain.personality;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Klasa CategoryAttribute
 * Klasa odzwierciedlająca cechę osobowości,
 * która należy do odpowiedniej kategorii (klasa PersonalityCategory).
 */
@Entity
@Table(name = "CATEGORY_ATTRIBUTE")
public class CategoryAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ATTRIBUTE_PK")
    @SequenceGenerator(sequenceName = "CATEGORY_ATTRIBUTE_PK", initialValue = 1, allocationSize = 1, name = "CATEGORY_ATTRIBUTE_PK")
    private Long id;

    @Column(length = 500)
    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private PersonalityCategory personalityCategory;

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
