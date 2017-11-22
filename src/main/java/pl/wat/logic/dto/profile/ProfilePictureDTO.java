package pl.wat.logic.dto.profile;

import pl.wat.logic.dto.user.UserDTO;

import java.util.Date;

public class ProfilePictureDTO {
    private Long id;
    private UserDTO user;
    private Date addDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}
