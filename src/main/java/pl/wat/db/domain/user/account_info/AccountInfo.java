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

    @Column(nullable = false)
    private boolean active;

    @Column(name = "last_Logout_Date")
    private Timestamp lastLogoutDate;

    public Date getAccountCreateDate() {
        return accountCreateDate;
    }

    public void setAccountCreateDate(Date accountCreateDate) {
        this.accountCreateDate = accountCreateDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getLastLogoutDate() {
        return lastLogoutDate;
    }

    public void setLastLogoutDate(Timestamp lastLogoutDate) {
        this.lastLogoutDate = lastLogoutDate;
    }
}
