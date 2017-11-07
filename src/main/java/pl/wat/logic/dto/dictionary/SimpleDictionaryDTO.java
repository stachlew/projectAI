package pl.wat.logic.dto.dictionary;

import pl.wat.db.domain.dictionary.SimpleDictionary;

public class SimpleDictionaryDTO {
    private int id;
    private String description;

    public SimpleDictionaryDTO() {
    }

    public SimpleDictionaryDTO(int id, String description) {
        this.id = id;
        this.description = description;
    }

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
