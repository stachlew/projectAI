package pl.wat.db.domain.localization;

import javax.persistence.*;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGION_PK")
    @SequenceGenerator(sequenceName = "REGION_PK", initialValue = 1, allocationSize = 1, name = "REGION_PK")
    private Long id;

    @Column(name = "region_name")
    private String regionName;

    public Region() {
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
