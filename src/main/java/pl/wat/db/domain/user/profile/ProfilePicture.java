package pl.wat.db.domain.user.profile;

import org.hibernate.annotations.ColumnDefault;
import pl.wat.db.domain.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Profile_Picture")
public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Profile_Picture_PK")
    @SequenceGenerator(sequenceName = "Profile_Picture_PK", initialValue = 1, allocationSize = 1, name = "Profile_Picture_PK")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "add_date",nullable = false)
    @ColumnDefault(value = "sysdate")
    private Date addDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}
