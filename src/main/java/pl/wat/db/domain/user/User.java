package pl.wat.db.domain.user;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.Lazy;
import pl.wat.db.domain.localization.City;

import pl.wat.db.domain.user.profile.attributes.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(sequenceName = "USER_SEQ", initialValue = 1, allocationSize = 1, name = "USER_SEQ")
    private Long id;

    @Column(length = 50, unique = true)
    @NotNull
    @Size(min = 2, max = 50)
    private String username;

    @Column(length = 100)
    @NotNull
    @Size(min = 2, max = 100)
    private String password;

    @Column(length = 50)
    @NotNull
    @Size(min = 2, max = 50)
    private String firstname;

    @Column(length = 50)
    @NotNull
    @Size(min = 2, max = 50)
    private String lastname;

    @Column(length = 50)
    @NotNull
    @Size(min = 2, max = 50)
    private String email;

    @Column(name="birth_Date")
    private Date birthDate;

    @Column(name="profile_photo_id", nullable = true)
    private Integer profilePhotoId;

    @NotNull
    private boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date lastpassres;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "ID")},
            uniqueConstraints = {@UniqueConstraint(
                    columnNames = {"user_id", "authority_id"})})
    private List<Authority> authorities;

    @Column
    private boolean isMan;



    @ManyToOne
    @JoinColumn(name="zodiac_Sign_id")
    private ZodiacSign zodiacSign;

    @ManyToOne
    @JoinColumn(name = "martial_status_id")
    private MartialStatus martialStatus;

    @Column
    private String profession;

    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


    @ManyToOne
    @JoinColumn(name = "figure_id")
    private Figure figure;

    @Column
    private Integer height;

    @ManyToOne
    @JoinColumn(name = "hair_color_id")
    private HairColor hairColor;

    @ManyToOne
    @JoinColumn(name="eye_color_id")
    private EyeColor eyeColor;

    @Column
    private String smoking;

    @Column
    private String drinking;

    @Column
    private String kids;

    @ManyToOne
    @JoinColumn(name = "religion_id")
    private Religion religion;

    @Column(length = 4000)
    private String description;

    @Column(name = "account_create_date",nullable = false)
    @ColumnDefault(value = "sysdate")
    private Date accountCreateDate;


    @Column(name = "last_Logout_Date")
    private Timestamp lastLogoutDate;


    public User() {
    }

    public User(String username, String password, String firstname, String lastname, String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean getEnabled() {
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

    public Date getLastpassres() {
        return lastpassres;
    }

    public void setLastpassres(Date lastpassres) {
        this.lastpassres = lastpassres;
    }

    public boolean isEnabled() {
        return enabled;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getProfilePhotoId() {
        return profilePhotoId;
    }

    public void setProfilePhotoId(Integer profilePhotoId) {
        this.profilePhotoId = profilePhotoId;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }


    public ZodiacSign getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(ZodiacSign zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public MartialStatus getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(MartialStatus martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
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

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}