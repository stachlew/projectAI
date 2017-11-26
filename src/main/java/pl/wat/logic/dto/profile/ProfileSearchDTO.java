package pl.wat.logic.dto.profile;

import pl.wat.logic.dto.dictionary.SimpleDictionaryDTO;
import pl.wat.logic.dto.localization.CityDTO;
import pl.wat.logic.dto.localization.RegionDTO;

public class ProfileSearchDTO {
    public Long id;
    //Pola na razie dostępne na froncie jako pola wyszukiwania osób
    public RegionDTO region;
    public CityDTO city;
    public int ageFrom;
    public int ageTo;
    public String sex;
    public SimpleDictionaryDTO education;
    public SimpleDictionaryDTO smoking;
    public SimpleDictionaryDTO drinking;
    public SimpleDictionaryDTO kids;

    public int pageNo;
    public int pageSize;
    public int countElements;
    public int countPage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegionDTO getRegion() {
        return region;
    }

    public void setRegion(RegionDTO region) {
        this.region = region;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public SimpleDictionaryDTO getSmoking() {
        return smoking;
    }

    public void setSmoking(SimpleDictionaryDTO smoking) {
        this.smoking = smoking;
    }

    public SimpleDictionaryDTO getDrinking() {
        return drinking;
    }

    public void setDrinking(SimpleDictionaryDTO drinking) {
        this.drinking = drinking;
    }

    public SimpleDictionaryDTO getKids() {
        return kids;
    }

    public void setKids(SimpleDictionaryDTO kids) {
        this.kids = kids;
    }

    public SimpleDictionaryDTO getEducation() {
        return education;
    }

    public void setEducation(SimpleDictionaryDTO education) {
        this.education = education;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getCountElements() {
        return countElements;
    }

    public void setCountElements(int countElements) {
        this.countElements = countElements;
    }
}
