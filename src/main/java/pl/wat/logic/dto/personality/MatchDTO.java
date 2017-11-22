package pl.wat.logic.dto.personality;

import pl.wat.db.domain.personality.CategoryAttribute;

public class MatchDTO {

    PersonalityCategoryDTO categoryAttribute;
    Double matchPercent;

    public PersonalityCategoryDTO getCategoryAttribute() {
        return categoryAttribute;
    }

    public void setCategoryAttribute(PersonalityCategoryDTO categoryAttribute) {
        this.categoryAttribute = categoryAttribute;
    }

    public Double getMatchPercent() {
        return matchPercent;
    }

    public void setMatchPercent(Double matchPercent) {
        this.matchPercent = matchPercent;
    }
}
