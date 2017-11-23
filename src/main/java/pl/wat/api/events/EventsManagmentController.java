package pl.wat.api.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.wat.api.util.BaseController;
import pl.wat.logic.dto.event.EventDTO;
import pl.wat.logic.service.event.EventService;
import pl.wat.logic.service.utils.UtilService;

import java.util.List;

@RestController
@RequestMapping("/api/events-managment")
public class EventsManagmentController extends BaseController{

    @Autowired
    EventService eventService;
    @Autowired
    UtilService utilService;
    //wszystkie wydarzenia usera
    @RequestMapping(value = "/manager-events",method = RequestMethod.GET)
    @PreAuthorize("hasRole('MANAGER')")
    @ResponseBody
    public List<EventDTO> getManagerEvent(Authentication auth){
        Long userId = this.utilService.getUserId(auth);
        return eventService.getManagerEvents(userId);
    }

    //detale wydarzenia usera
    //detale wydarzenia
    @RequestMapping(value = "/get-details/{idEvent}",method = RequestMethod.GET)
    @PreAuthorize("hasRole('MANAGER')")
    @ResponseBody
    public EventDTO getEventDetails(Authentication auth, @PathVariable Long idEvent){
        Long userId = this.utilService.getUserId(auth);
        return eventService.getEventDetails(idEvent);
    }

    //utworzenie/modyfikacja wydarzenia
    @RequestMapping(value = "/save-event",method = RequestMethod.POST)
    @PreAuthorize("hasRole('MANAGER')")
    @ResponseBody
    public EventDTO saveEvent(@RequestBody EventDTO eventDTO, Authentication auth){
        return eventService.saveEvent(eventDTO, this.getLoggerUser(auth));
    }
}
