package pl.wat.logic.dto.user;

import pl.wat.db.domain.localization.City;
import pl.wat.db.domain.user.Authority;
import pl.wat.logic.dto.dictionary.SimpleDictionaryDTO;
import pl.wat.logic.dto.event.LocalizationDTO;
import pl.wat.logic.dto.localization.CityDTO;
import pl.wat.db.domain.personality.Match;
import pl.wat.logic.dto.personality.UserPersonalityAttributeDTO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Integer profilePhotoId;
    private Date accountCreateDate;
    private Timestamp lastLogoutDate;
    private Date lastpassres;
    private boolean enabled;
    private List<Authority> authorities;
    private int age;
    private String userType;

    private boolean man;
    private String sex;
    private Date birthDate;
    private Integer height;
    private String smoking;
    private String drinking;
    private String kids;
    private String profession;
    private String description;
    private CityDTO city;
    private SimpleDictionaryDTO zodiacSign;
    private SimpleDictionaryDTO martialStatus;
    private SimpleDictionaryDTO education;
    private SimpleDictionaryDTO figure;
    private SimpleDictionaryDTO hairColor;
    private SimpleDictionaryDTO eyeColor;
    private SimpleDictionaryDTO religion;
    private List<Match> matchList;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProfilePhotoId() {
        return profilePhotoId;
    }

    public void setProfilePhotoId(Integer profilePhotoId) {
        this.profilePhotoId = profilePhotoId;
    }

    public Date getAccountCreateDate() {
        return accountCreateDate;
    }

    public void setAccountCreateDate(Date accountCreateDate) {
        this.accountCreateDate = accountCreateDate;
    }

    public Timestamp getLastLogoutDate() {
        return lastLogoutDate;
    }

    public void setLastLogoutDate(Timestamp lastLogoutDate) {
        this.lastLogoutDate = lastLogoutDate;
    }

    public Date getLastpassres() {
        return lastpassres;
    }

    public void setLastpassres(Date lastpassres) {
        this.lastpassres = lastpassres;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
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

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
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

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }
}
