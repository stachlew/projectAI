package pl.wat.db.domain.user.profile;

import org.hibernate.annotations.ColumnDefault;
import pl.wat.db.domain.user.profile.attributes.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


@Embeddable
public class Profile {


    @Column
    @Enumerated(EnumType.STRING)
    private Sex sex;

   @Column(name="birth_Date")
   private Date birthDate;

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

    @Column
    private String city;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "figure_id")
    private Figure figure;

    @Column
    private int growth;

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
    private Region religion;

    @Column(length = 4000)
    private String description;

    public Profile() {
    }



    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }





    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
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

    public Region getReligion() {
        return religion;
    }

    public void setReligion(Region religion) {
        this.religion = religion;
    }
}

