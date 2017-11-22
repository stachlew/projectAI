package pl.wat.db.domain.user.profile.attributes;

import javax.persistence.Entity;


public class Dictionary {
    public Long id;
    public String description;

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
