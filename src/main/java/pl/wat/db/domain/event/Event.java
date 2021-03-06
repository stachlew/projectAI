package pl.wat.db.domain.event;


import org.springframework.context.annotation.Lazy;
import pl.wat.db.domain.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_PK")
    @SequenceGenerator(sequenceName = "EVENT_PK", initialValue = 1, allocationSize = 1, name = "EVENT_PK")
    private Long id;

    @Column
    private Date eventStart;

    @Column
    private boolean enabled;

    @Column
    private int capacity;

    @Column(length = 1000)
    private String title;

    @Column(length = 4000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "localozation_id")
    private Localization localization;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @Lazy
    private User organizer;

    public Event() {
    }

    public Event(Date eventStart, boolean enabled, int capacity, String title, String description, Localization localization, User organizer) {
        this.eventStart = eventStart;
        this.enabled = enabled;
        this.capacity = capacity;
        this.title = title;
        this.description = description;
        this.localization = localization;
        this.organizer = organizer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
