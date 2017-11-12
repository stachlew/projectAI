package pl.wat.logic.service.utils;

import org.springframework.stereotype.Service;
import pl.wat.db.domain.conversation.Conversation;
import pl.wat.db.domain.conversation.PrivateMessage;
import pl.wat.db.domain.event.Event;
import pl.wat.db.domain.event.Localization;
import pl.wat.db.domain.event.Participant;
import pl.wat.db.domain.localization.City;
import pl.wat.db.domain.localization.Region;
import pl.wat.db.domain.user.Authority;
import pl.wat.db.domain.user.User;
import pl.wat.db.domain.user.profile.Profile;
import pl.wat.logic.dto.conversation.ConversationDTO;
import pl.wat.logic.dto.conversation.PrivateMessageDTO;
import pl.wat.logic.dto.event.EventDTO;
import pl.wat.logic.dto.event.LocalizationDTO;
import pl.wat.logic.dto.event.ParticipantDTO;
import pl.wat.logic.dto.localization.CityDTO;
import pl.wat.logic.dto.localization.RegionDTO;
import pl.wat.logic.dto.profile.ProfileDTO;
import pl.wat.logic.dto.user.UserDTO;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

@Service
public class TransformService {

    public UserDTO toDto(User entity){
        if(entity!=null){
            UserDTO dto = new UserDTO();
            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
            dto.setPassword(entity.getPassword());
            dto.setFirstname(entity.getFirstname());
            dto.setLastname(entity.getLastname());
            dto.setEmail(entity.getEmail());
            dto.setAccountCreateDate(entity.getAccountInfo().getAccountCreateDate()); //WINA Embedded
            dto.setLastLogoutDate(entity.getAccountInfo().getLastLogoutDate());
            dto.setLastpassres(entity.getLastpassres());
            dto.setActive(entity.getAccountInfo().isActive());
            dto.setEnabled(entity.getEnabled());
            dto.setAuthorities(toDTO(entity.getAuthorities()));
            dto.setAge(this.countAge(entity));
            return dto;
        }else {
            return null;
        }
    }

    public UserDTO toSimpleDto(User entity){
        if(entity!=null){
            UserDTO dto = new UserDTO();
            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
            dto.setPassword(null);
            dto.setFirstname(entity.getFirstname());
            dto.setLastname(null);
            dto.setEmail(null);
            dto.setAccountCreateDate(null);
            dto.setLastLogoutDate(null);
            dto.setLastpassres(null);
            dto.setActive(false);
            dto.setEnabled(false);
            dto.setAuthorities(null);
            dto.setAge(this.countAge(entity));
            return dto;
        }else {
            return null;
        }
    }

    public List<Authority> toDTO(List<Authority> entity){
        List<Authority> dtos = new LinkedList<>();
        entity.forEach( ent -> ent.setUsers(null));
        return dtos;
    }

    public User toEntity(UserDTO dto){
        if(dto !=null){
            User entity = new User();
            entity.setId(dto.getId());
            entity.setUsername(dto.getUsername());
            entity.setPassword(dto.getPassword());
            entity.setFirstname(dto.getFirstname());
            entity.setLastname(dto.getLastname());
            // ... itd
            return entity;
        }else {
            return null;
        }
    }

    public Conversation toEntity(ConversationDTO dto){
        if(dto==null) return null;
        Conversation entity = new Conversation();
        entity.setId(dto.getId());
        entity.setMemberOne(toEntity(dto.getMemberOne()));
        entity.setMemberTwo(toEntity(dto.getMemberTwo()));
        return entity;
    }

    public ConversationDTO toDTO(Conversation entity){
        if(entity==null) return null;
        ConversationDTO dto = new ConversationDTO();
        dto.setId(entity.getId());
        dto.setMemberOne(toSimpleDto(entity.getMemberOne()));
        dto.setMemberTwo(toSimpleDto(entity.getMemberTwo()));
        return dto;
    }

    public PrivateMessage toEntity(PrivateMessageDTO dto){
        if(dto==null) return null;
        PrivateMessage entity = new PrivateMessage();
        entity.setId(dto.getId());
        entity.setConversation(toEntity(dto.getConversation()));
        entity.setSendDate(dto.getSendDate());
        entity.setSender(toEntity(dto.getSender()));
        entity.setTextMessage(dto.getTextMessage());
        return entity;
    }

    public PrivateMessageDTO toDTO(PrivateMessage entity){
        if(entity==null) return null;
        PrivateMessageDTO dto = new PrivateMessageDTO();
        dto.setId(entity.getId());
        dto.setConversation(toDTO(entity.getConversation()));
        dto.setSendDate(entity.getSendDate());
        dto.setSender(toSimpleDto(entity.getSender()));
        dto.setTextMessage(entity.getTextMessage());
        return dto;
    }

    public ProfileDTO toDTO(Profile entity){
        if(entity!=null){
            ProfileDTO dto = new ProfileDTO();
            dto.setMan(entity.isMan());
            dto.setDescription(entity.getDescription());
            //... itd
            return dto;
        }else {
            return null;
        }
    }

    public Profile toEntity(ProfileDTO dto){
        if(dto!=null){
            Profile entity = new Profile();
            entity.setMan(dto.isMan());
            entity.setDescription(dto.getDescription());
            //... itd
            return entity;
        }else {
            return null;
        }
    }

    public EventDTO toDTO(Event event){
        if(event!=null){
            EventDTO dto = new EventDTO();
            dto.setTitle(event.getTitle());
            dto.setId(event.getId());
            dto.setEventStart(event.getEventStart());
            dto.setDescription(event.getDescription());
            dto.setCapacity(event.getCapacity());
            dto.setLocalization(toDTO(event.getLocalization()));
            dto.setOrganizer(toDto(event.getOrganizer()));

            return dto;
        }
        else
            return null;
    }

    public Event toEntity(EventDTO eventDTO){
        if(eventDTO!=null){
            Event event = new Event();
            event.setDescription(eventDTO.getDescription());
            event.setCapacity(eventDTO.getCapacity());
            event.setEventStart(eventDTO.getEventStart());
            event.setTitle(eventDTO.getTitle());
            event.setLocalization(toEntity(eventDTO.getLocalization()));
            event.setOrganizer(toEntity(eventDTO.getOrganizer()));
            return event;
        }
        else
        return null;
    }

    public CityDTO toDTO(City city){
        if (city!=null){
            CityDTO dto = new CityDTO();
            dto.setId(city.getId());
            dto.setCityName(city.getCityName());
            dto.setRegion(this.toDTO(city.getRegion()));
            return dto;
        }
        else
            return null;
    }

    public City toEntity(CityDTO cityDTO){
        if(cityDTO!=null){
            City city = new City();
            city.setCityName(cityDTO.getCityName());
            city.setRegion(toEntity(cityDTO.getRegion()));
            return city;
        }
        else
            return null;
    }

    public RegionDTO toDTO(Region region){
        if(region!=null){
            RegionDTO dto = new RegionDTO();
            dto.setId(region.getId());
            dto.setRegionName(region.getRegionName());
            return dto;
        }
        else
            return null;

    }

    public Region toEntity(RegionDTO regionDTO){
        if(regionDTO!=null){
            Region entity = new Region();
            entity.setRegionName(regionDTO.getRegionName());
            return entity;
        }
        else
            return null;
    }

    public LocalizationDTO toDTO(Localization localization){
        if(localization!=null){
            LocalizationDTO dto = new LocalizationDTO();
            dto.setAddress(localization.getAddress());
            dto.setCity(toDTO(localization.getCity()));
            dto.setGeoLength(localization.getGeoLength());
            dto.setGeoWidth(localization.getGeoWidth());
            dto.setId(localization.getId());
            return dto;
        }
        else
            return null;
    }

    public Localization toEntity(LocalizationDTO dto){
        if(dto!=null){
            Localization entity = new Localization();
            entity.setCity(toEntity(dto.getCity()));
            entity.setAddress(dto.getAddress());
            entity.setGeoLength(dto.getGeoLength());
            entity.setGeoWidth(dto.getGeoWidth());
            return entity;
        }else
            return null;
    }

    public ParticipantDTO toDTO(Participant participant){
        if(participant!=null){
            ParticipantDTO dto = new ParticipantDTO();
            dto.setId(participant.getId());
            dto.setUser(toSimpleDto(participant.getUser()));
            dto.setEvent(toDTO(participant.getEvent()));
            return dto;
        }
        else
            return null;
    }

    public Participant toEntity(ParticipantDTO dto){
        if(dto!=null){
            Participant entity = new Participant();
            entity.setUser(toEntity(dto.getUser()));
            entity.setEvent(toEntity(dto.getEvent()));
            return entity;
        }
        else
            return null;
    }

    private int countAge(User entity){
        if(entity!=null && entity.getBirthDate()!=null){
            LocalDate now = LocalDate.now();
            LocalDate birthday = entity.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(birthday,now).getYears();
        }else {
            return 0;
        }
    }





}
