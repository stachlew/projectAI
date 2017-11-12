package pl.wat.db.domain.event;

import pl.wat.db.domain.localization.City;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Localization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Localization_PK")
    @SequenceGenerator(sequenceName = "Localization_PK", initialValue = 1, allocationSize = 1, name = "Localization_PK")
    private int id;

    @Column
    private String address;


    @ManyToOne
    @JoinColumn(name ="city_id")
    private City city;



    @Column(length = 25)
    @Size(max = 25)
    private String geoLength;

    @Column(length = 25)
    @Size(max = 25)
    private String geoWidth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getGeoLength() {
        return geoLength;
    }

    public void setGeoLength(String geoLength) {
        this.geoLength = geoLength;
    }

    public String getGeoWidth() {
        return geoWidth;
    }

    public void setGeoWidth(String geoWidth) {
        this.geoWidth = geoWidth;
    }
}
