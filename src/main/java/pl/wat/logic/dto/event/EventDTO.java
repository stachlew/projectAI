package pl.wat.logic.dto.event;
import pl.wat.db.domain.event.Localization;
import pl.wat.db.domain.event.Participant;
import pl.wat.db.domain.user.User;
import pl.wat.logic.dto.user.UserDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class EventDTO {
    private int id;
    private Date eventStart;
    private int capacity;
    private String title;
    private String description;
    private LocalizationDTO localization;
    private UserDTO organizer;
    private List<ParticipantDTO> participantList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEventStart() {
        return eventStart;
    }

    public void setEventStart(Date eventStart) {
        this.eventStart = eventStart;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalizationDTO getLocalization() {
        return localization;
    }

    public void setLocalization(LocalizationDTO localization) {
        this.localization = localization;
    }

    public UserDTO getOrganizer() {
        return organizer;
    }

    public void setOrganizer(UserDTO organizer) {
        this.organizer = organizer;
    }

    public List<ParticipantDTO> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<ParticipantDTO> participantList) {
        this.participantList = participantList;
    }
}
