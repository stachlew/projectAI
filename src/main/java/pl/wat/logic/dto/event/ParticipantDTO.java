package pl.wat.logic.dto.event;

import pl.wat.logic.dto.user.UserDTO;

public class ParticipantDTO {

    private int id;
    private EventDTO event;
    private UserDTO user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
