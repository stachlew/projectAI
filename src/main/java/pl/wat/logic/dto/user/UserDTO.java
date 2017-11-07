package pl.wat.logic.dto.user;

import pl.wat.db.domain.user.Authority;
import pl.wat.logic.dto.profile.ProfileDTO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Date accountCreateDate;
    private Timestamp lastLogoutDate;
    private Date lastpassres;
    private boolean active;
    private boolean enabled;
    private ProfileDTO profile;
    private List<Authority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAccountCreateDate() {
        return accountCreateDate;
    }

    public void setAccountCreateDate(Date accountCreateDate) {
        this.accountCreateDate = accountCreateDate;
    }

    public Timestamp getLastLogoutDate() {
        return lastLogoutDate;
    }

    public void setLastLogoutDate(Timestamp lastLogoutDate) {
        this.lastLogoutDate = lastLogoutDate;
    }

    public Date getLastpassres() {
        return lastpassres;
    }

    public void setLastpassres(Date lastpassres) {
        this.lastpassres = lastpassres;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}