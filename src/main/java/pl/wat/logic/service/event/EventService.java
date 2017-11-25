package pl.wat.logic.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wat.db.domain.conversation.Conversation;
import pl.wat.db.domain.event.Event;
import pl.wat.db.domain.event.Localization;
import pl.wat.db.domain.event.Participant;
import pl.wat.db.domain.user.User;
import pl.wat.db.repository.conversation.ConversationRepository;
import pl.wat.db.repository.event.EventRepository;
import pl.wat.db.repository.event.LocalizatonRepository;
import pl.wat.db.repository.event.ParticipantRepository;
import pl.wat.db.repository.user.UserRepository;
import pl.wat.logic.dto.event.EventDTO;
import pl.wat.logic.dto.event.EventSearchDTO;
import pl.wat.logic.dto.event.ParticipantDTO;
import pl.wat.logic.dto.user.UserDTO;
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
    @Autowired
    LocalizatonRepository localizatonRepository;

    public EventDTO getEventManagmentDetails(Long idEvent){
        Event event = eventRepository.findOne(idEvent);
        EventDTO eventDTO = transformService.toSimpleDTO(event);
        LinkedList<UserDTO> participants = new LinkedList<>();
        participantRepository.findByEvent(event).forEach( participant -> {
            participants.add(transformService.toSimpleDto(participant.getUser()));
        });
        eventDTO.setParticipantList(participants);
        return eventDTO;
    }

    public EventDTO getEventDetails(Long idEvent, Long idUser){
        Event event = eventRepository.findOne(idEvent);
        EventDTO eventDTO = transformService.toSimpleDTO(event);
        eventDTO.setParticipantList(getEventParticipants(event));
        if(participantRepository.findFirstByEventAndUser(event,userRepository.findOne(idUser))!=null){
            eventDTO.setParticipant(true);
        }else {
            eventDTO.setParticipant(false);
        }
        return eventDTO;
    }

    private List<UserDTO> getEventParticipants(Event event){
        List<Participant> fetchedParticipants = participantRepository.findByEvent(event);
        List<UserDTO> participants = new LinkedList<>();
        fetchedParticipants.forEach(fetched->{
            UserDTO dto = transformService.toSimpleParticipantDto(fetched.getUser());
            participants.add(dto);
        });
        return participants;
    }

    public boolean saveParticipant(Long idEvent, Long idUser) {
        Event event = eventRepository.findOne(idEvent);
        User user = userRepository.findOne(idUser);

        Participant alreadySaved = participantRepository.findFirstByEventAndUser(event,user);

        if(event!=null && user!=null && alreadySaved==null){
            if(event.getCapacity()>participantRepository.countByEvent(event)){
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

    public boolean deleteParticipant(Long idEvent, Long idUser) {
        Event event = eventRepository.findOne(idEvent);
        User user = userRepository.findOne(idUser);
        if(event!=null && user!=null){
            Participant saved = participantRepository.findFirstByEventAndUser(event,user);
            if(saved!=null){
                participantRepository.delete(saved.getId());
                return true;
            }
        }
        return false;
    }

    public List<EventDTO> getUserParticipantEvents(Long userId) {
        User user = userRepository.getOne(userId);
        List<Participant> participants = participantRepository.findByUser(user);
        List<EventDTO> eventDTOList = new LinkedList<>();
        participants.forEach(participant -> {
            eventDTOList.add(transformService.toSimpleDTO(participant.getEvent()));
        });
        return eventDTOList;
    }

    public PageResponse getEvents(EventSearchDTO filter) { //TODO WYSZUKIWANIE WG FILTRA
        List<Event> fethed = eventRepository.findAll();
        List<EventDTO> dtos = new LinkedList<>();
        fethed.forEach(event -> dtos.add(transformService.toSimpleDTO(event)));

        PageResponse pageResponse = new PageResponse<EventDTO>();
        pageResponse.value = dtos;
        pageResponse.pageNo = filter.getPageNo(); //TODO
        pageResponse.elementsCount = 0;
        pageResponse.elementsCount = 100;
        return pageResponse;
    }

    public List<EventDTO> getManagerEvents(Long userId) {
        User user = userRepository.findOne(userId);
        LinkedList<EventDTO> eventDTOList = new LinkedList<>();
        eventRepository.findByAndOrganizer(user).forEach(event -> {
            EventDTO eventDTO = transformService.toSimpleDTO(event);

            LinkedList<UserDTO> participants = new LinkedList<>();
            participantRepository.findByEvent(event).forEach( participant -> {
                participants.add(transformService.toSimpleDto(participant.getUser()));
            });
            eventDTO.setParticipantList(participants);
            eventDTOList.add(eventDTO);
        });
        return eventDTOList;
    }

    @Autowired
    ConversationRepository conversationRepository;
    @Transactional
    public EventDTO saveEvent(EventDTO eventDTO, UserDTO user) {
        Event event = transformService.toEntity(eventDTO);
        User organizer = userRepository.findByUsername(user.getUsername());
        event.setOrganizer(organizer);
        localizatonRepository.save(event.getLocalization());
        event = eventRepository.save(event);
        return transformService.toDTO(event);
    }
}
