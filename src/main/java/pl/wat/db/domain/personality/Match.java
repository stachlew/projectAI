package pl.wat.db.domain.personality;

import java.math.BigDecimal;

public class Match {
    String description;
    BigDecimal percentage;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public Match() {
    }

    public Match(String description, BigDecimal percentage) {
        this.description = description;
        this.percentage = percentage;
    }
}
