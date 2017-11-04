package pl.wat.db.domain.speeddate;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class SpeeddatePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Speeddate_Picture_PK")
    @SequenceGenerator(sequenceName = "Speeddate_Picture_PK", initialValue = 1, allocationSize = 1, name = "Speeddate_Picture_PK")
    private int id;

    @ManyToOne
    @JoinColumn(name = "speeddate_id")
    private Speeddate speeddate;

    @Lob
    @Column()
    @Basic(fetch = FetchType.LAZY)
    private Blob picture;
}
