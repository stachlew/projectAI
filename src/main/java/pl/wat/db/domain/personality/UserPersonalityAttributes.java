package pl.wat.db.domain.personality;

import pl.wat.db.domain.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Klasa UserPersonalityAttributes
 * Klasa intersekcja pomiędzy User a CategoryAttribute
 *
 */
@Entity
@Table(name = "USER_PERSONALITY_ATTR")
public class UserPersonalityAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_PERSONALITY_ATTR_PK")
    @SequenceGenerator(sequenceName = "USER_PERSONALITY_ATTR_PK", initialValue = 1, allocationSize = 1, name = "USER_PERSONALITY_ATTR_PK")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private CategoryAttribute categoryAttribute;

    @Column(length = 1)
    @NotNull
    private String answer;

    @Column(length = 1, name = "partner_answer")
    @NotNull
    private String partnerAnswer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CategoryAttribute getCategoryAttribute() {
        return categoryAttribute;
    }

    public void setCategoryAttribute(CategoryAttribute categoryAttribute) {
        this.categoryAttribute = categoryAttribute;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
