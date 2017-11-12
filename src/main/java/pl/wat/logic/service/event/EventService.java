package pl.wat.logic.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.db.domain.event.Event;
import pl.wat.db.repository.event.EventRepository;
import pl.wat.db.repository.event.ParticipantRepository;
import pl.wat.logic.dto.event.EventDTO;
import pl.wat.logic.dto.event.ParticipantDTO;
import pl.wat.logic.service.utils.TransformService;

import java.util.LinkedList;
import java.util.concurrent.TransferQueue;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ParticipantRepository participantRepository;
    @Autowired
    TransformService transformService;

    public EventDTO getEventDetails(int idEvent){
        Event event = eventRepository.findOne(idEvent);
        EventDTO eventDTO = transformService.toDTO(event);
        LinkedList<ParticipantDTO> participantDTOList = new LinkedList<>();
        participantRepository.findByEvent(event).forEach( participant -> {
            participantDTOList.add(transformService.toDTO(participant));
        });
        eventDTO.setParticipantList(participantDTOList);
        return eventDTO;
    }


}
