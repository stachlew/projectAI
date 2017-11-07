package pl.wat.logic.dto.profile;
import pl.wat.logic.dto.dictionary.SimpleDictionaryDTO;

import java.sql.Date;

public class ProfileDTO {
    private boolean isMan;
    private Date birthDate;
    private int growth;
    private String smoking;
    private String drinking;
    private String kids;
    private String profession;
    private String description;
    private String city;
    private SimpleDictionaryDTO zodiacSign;
    private SimpleDictionaryDTO martialStatus;
    private SimpleDictionaryDTO education;
    private SimpleDictionaryDTO region;
    private SimpleDictionaryDTO figure;
    private SimpleDictionaryDTO hairColor;
    private SimpleDictionaryDTO eyeColor;
    private SimpleDictionaryDTO religion;

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getDrinking() {
        return drinking;
    }

    public void setDrinking(String drinking) {
        this.drinking = drinking;
    }

    public String getKids() {
        return kids;
    }

    public void setKids(String kids) {
        this.kids = kids;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public SimpleDictionaryDTO getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(SimpleDictionaryDTO zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public SimpleDictionaryDTO getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(SimpleDictionaryDTO martialStatus) {
        this.martialStatus = martialStatus;
    }

    public SimpleDictionaryDTO getEducation() {
        return education;
    }

    public void setEducation(SimpleDictionaryDTO education) {
        this.education = education;
    }

    public SimpleDictionaryDTO getRegion() {
        return region;
    }

    public void setRegion(SimpleDictionaryDTO region) {
        this.region = region;
    }

    public SimpleDictionaryDTO getFigure() {
        return figure;
    }

    public void setFigure(SimpleDictionaryDTO figure) {
        this.figure = figure;
    }

    public SimpleDictionaryDTO getHairColor() {
        return hairColor;
    }

    public void setHairColor(SimpleDictionaryDTO hairColor) {
        this.hairColor = hairColor;
    }

    public SimpleDictionaryDTO getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(SimpleDictionaryDTO eyeColor) {
        this.eyeColor = eyeColor;
    }

    public SimpleDictionaryDTO getReligion() {
        return religion;
    }

    public void setReligion(SimpleDictionaryDTO religion) {
        this.religion = religion;
    }
}
