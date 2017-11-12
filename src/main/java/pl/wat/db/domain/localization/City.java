package pl.wat.db.domain.localization;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_PK")
    @SequenceGenerator(sequenceName = "CITY_PK", initialValue = 1, allocationSize = 1, name = "CITY_PK")
    private int id;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name ="id_region")
    private Region region;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
