package pl.wat.api.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.wat.logic.dto.event.EventDTO;
import pl.wat.logic.dto.event.EventSearchDTO;
import pl.wat.logic.service.event.EventService;
import pl.wat.logic.service.utils.PageResponse;
import pl.wat.logic.service.utils.UtilService;

import java.util.List;

@RestController
@RequestMapping("/api/events-guest")
public class EventsGuestController {

    @Autowired
    UtilService utilService;
    @Autowired
    EventService eventService;

    //lista wydarzeń
    @RequestMapping(value = "/getEvents",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public PageResponse getEvent(Authentication auth, @RequestBody EventSearchDTO filter){
        return eventService.getEvents(filter);
    }

    //lista wydarzeń na które jesteśmy zapisanii
    @RequestMapping(value = "/getUserParticipantEvent",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public List<EventDTO> getUserParticipantEvent(Authentication auth){
        Long userId = this.utilService.getUserId(auth);
        return eventService.getUserParticipantEvents(userId);
    }

    //zapis na wydarzenie
    @RequestMapping(value = "/saveParticipant",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public boolean saveParticipant(Authentication auth , @RequestBody Long idEvent){
        Long userId = this.utilService.getUserId(auth);
        return eventService.saveParticipant(idEvent, userId);
    }

    //wypisanie się z wydarzenia
    @RequestMapping(value = "/deleteParticipant",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public boolean deleteParticipant(Authentication auth , @RequestBody Long idEvent){
        Long userId = this.utilService.getUserId(auth);
        return eventService.deleteParticipant(idEvent, userId);
    }

    //detale wydarzenia
    @RequestMapping(value = "/getDetails/{idEvent}",method = RequestMethod.GET)
    @ResponseBody
    public EventDTO getEventDetails(Authentication auth, @PathVariable Long idEvent){
        Long userId = this.utilService.getUserId(auth);
        EventDTO eventDTO = eventService.getEventDetails(idEvent,userId);
        return eventDTO;
    }


}
