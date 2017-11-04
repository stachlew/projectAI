package pl.wat.db.domain.user.profile;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.ColumnDefault;
import pl.wat.db.domain.user.User;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name = "Profile_Picture")
public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Profile_Picture_PK")
    @SequenceGenerator(sequenceName = "Profile_Picture_PK", initialValue = 1, allocationSize = 1, name = "Profile_Picture_PK")
    private int id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "add_date",nullable = false)
    @ColumnDefault(value = "sysdate")
    private Date addDate;

    @Lob
    @Column()
    @Basic(fetch = FetchType.LAZY)
    private Blob picture;
}
