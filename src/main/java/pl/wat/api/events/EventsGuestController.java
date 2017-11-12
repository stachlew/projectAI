package pl.wat.api.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.db.repository.event.EventRepository;
import pl.wat.logic.dto.event.EventDTO;
import pl.wat.logic.service.event.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/events-guest")
public class EventsGuestController {

    @Autowired
    EventService eventService;
    //lista wydarzen

    //zapis na wydarzenie

    //detale wydarzenia
    @RequestMapping(value = "/getDetails",method = RequestMethod.GET)
    @ResponseBody
    public EventDTO getRegions(Authentication auth,int idEvent){
        return eventService.getEventDetails(idEvent);
    }
}
