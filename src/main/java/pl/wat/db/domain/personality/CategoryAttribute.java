package pl.wat.db.domain.personality;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pers_category_attr")
public class CategoryAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_category_attr_seq")
    @SequenceGenerator(sequenceName = "pers_category_attr_seq", initialValue = 1, allocationSize = 1, name = "pers_category_attr_seq")
    private int id;

    @Column(length = 500)
    @NotNull
    private String description;

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
}
