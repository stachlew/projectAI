package pl.wat.logic.dto.personality;

import java.util.List;

public class PersonalityCategoryDTO {
    private Long id;
    private String description;
    private List<CategoryAttributeDTO> attributes;
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

    public List<CategoryAttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CategoryAttributeDTO> attributes) {
        this.attributes = attributes;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
