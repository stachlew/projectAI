package pl.wat.db.domain.event;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class EventPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Speeddate_Picture_PK")
    @SequenceGenerator(sequenceName = "Speeddate_Picture_PK", initialValue = 1, allocationSize = 1, name = "Speeddate_Picture_PK")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "speeddate_id")
    private Event event;

    @Lob
    @Column()
    @Basic(fetch = FetchType.LAZY)
    private Blob picture;
}
