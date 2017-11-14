package pl.wat.logic.dto.user;

import pl.wat.db.domain.user.Authority;
import pl.wat.logic.dto.event.LocalizationDTO;
import pl.wat.logic.dto.profile.ProfileDTO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Integer profilePhotoId;
    private Date accountCreateDate;
    private Timestamp lastLogoutDate;
    private Date lastpassres;
    private boolean active;
    private boolean enabled;
    private List<Authority> authorities;
    private int age;
    private String userType;
    private Date birthDay;
    private String sex;
    private LocalizationDTO localizationDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalizationDTO getLocalizationDTO() {
        return localizationDTO;
    }

    public void setLocalizationDTO(LocalizationDTO localizationDTO) {
        this.localizationDTO = localizationDTO;
    }
}
