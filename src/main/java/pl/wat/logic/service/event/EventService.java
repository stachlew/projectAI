package pl.wat.logic.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.db.domain.event.Event;
import pl.wat.db.domain.event.Participant;
import pl.wat.db.domain.user.User;
import pl.wat.db.repository.event.EventRepository;
import pl.wat.db.repository.event.ParticipantRepository;
import pl.wat.db.repository.user.UserRepository;
import pl.wat.logic.dto.event.EventDTO;
import pl.wat.logic.dto.event.EventSearchDTO;
import pl.wat.logic.dto.event.ParticipantDTO;
import pl.wat.logic.service.utils.PageResponse;
import pl.wat.logic.service.utils.TransformService;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TransferQueue;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ParticipantRepository participantRepository;
    @Autowired
    UserRepository userRepository;
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

    public EventDTO getEventDetails(int idEvent, int idUser){
        Event event = eventRepository.findOne(idEvent);
        EventDTO eventDTO = transformService.toDTO(event);
        LinkedList<ParticipantDTO> participantDTOList = new LinkedList<>();
        participantRepository.findByEvent(event).forEach( participant -> {
            participantDTOList.add(transformService.toDTO(participant));
        });
        eventDTO.setParticipantList(participantDTOList);
        if(participantRepository.findFirstByEventAndUser(event,userRepository.findOne(idUser))!=null){
            eventDTO.setParticipant(true);
        }else {
            eventDTO.setParticipant(false);
        }
        return eventDTO;
    }


    public boolean saveParticipant(int idEvent, int idUser) {
        Event event = eventRepository.findOne(idEvent);
        User user = userRepository.findOne(idUser);
        if(event!=null && user!=null){
            if(event.getCapacity()<participantRepository.countByEvent(event)){
                Participant participant = new Participant();
                participant.setUser(user);
                participant.setEvent(event);
                Participant save = participantRepository.save(participant);
                if (save!=null){
                    return true;
                }
            }
        }
        return false;
    }

    public List<EventDTO> getUserParticipantEvents(int userId) {
        User user = userRepository.getOne(userId);
        List<Participant> participants = participantRepository.findByUser(user);
        List<EventDTO> eventDTOList = new LinkedList<>();
        participants.forEach(participant -> {
            eventDTOList.add(transformService.toDTO(participant.getEvent()));
        });
        return eventDTOList;
    }

    public PageResponse getEvents(EventSearchDTO filter) { //TODO WYSZUKIWANIE WG FILTRA
        List<Event> fethed = eventRepository.findAll();
        List<EventDTO> dtos = new LinkedList<>();
        fethed.forEach(event -> dtos.add(transformService.toDTO(event)));

        PageResponse pageResponse = new PageResponse<EventDTO>();
        pageResponse.value = dtos;
        pageResponse.pageNo = filter.getPageNo(); //TODO
        pageResponse.elementsCount = 0;
        pageResponse.elementsCount = 100;
        return pageResponse;
    }

    public List<EventDTO> getUserEvent(int userId) {
        User user = userRepository.findOne(userId);
        LinkedList<EventDTO> eventDTOList = new LinkedList<>();
        eventRepository.findByAndOrganizer(user).forEach(event -> {
            eventDTOList.add(transformService.toDTO(event));
        });
        return eventDTOList;
    }

    public EventDTO saveEvent(EventDTO eventDTO) {
        Event event = transformService.toEntity(eventDTO);
        event = eventRepository.save(event);
        return transformService.toDTO(event);
    }
}
