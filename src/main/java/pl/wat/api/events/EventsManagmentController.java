package pl.wat.api.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.logic.dto.event.EventDTO;
import pl.wat.logic.service.event.EventService;
import pl.wat.logic.service.utils.UtilService;

import java.util.List;

@RestController
@RequestMapping("/api/events-managment")
public class EventsManagmentController {

    @Autowired
    EventService eventService;
    @Autowired
    UtilService utilService;
    //wszystkie wydarzenia usera
    @RequestMapping(value = "/getUserEvent",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public List<EventDTO> getUserEvent(Authentication auth){
        int userId = this.utilService.getUserId(auth);
        return eventService.getUserEvent(userId);
    }

    //detale wydarzenia usera
    //detale wydarzenia
    @RequestMapping(value = "/getDetails",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public EventDTO getEventDetails(Authentication auth,int idEvent){
        int userId = this.utilService.getUserId(auth);
        return eventService.getEventDetails(idEvent);
    }

    //utworzenie/modyfikacja wydarzenia
    @RequestMapping(value = "/setEvent",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public EventDTO setEvent(EventDTO eventDTO){
        return eventService.saveEvent(eventDTO);


    }
}
