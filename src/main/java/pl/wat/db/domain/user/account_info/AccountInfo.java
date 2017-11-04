package pl.wat.db.domain.user.account_info;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;
import java.sql.Timestamp;

@Embeddable
public class AccountInfo {
    @Column(name = "account_create_date",nullable = false)
    @ColumnDefault(value = "sysdate")
    private Date accountCreateDate;

    @Column(nullable = true)
    private boolean active;

    @Column(name = "last_Logout_Date")
    private Timestamp lastLogoutDate;
}
