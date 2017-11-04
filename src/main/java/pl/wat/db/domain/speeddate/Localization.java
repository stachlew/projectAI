package pl.wat.db.domain.speeddate;

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

    @Column
    private String city;

    @Column
    private String region;

    @Column(length = 25)
    @Size(max = 25)
    private String geoLength;

    @Column(length = 25)
    @Size(max = 25)
    private String geoWidth;

}
