package pl.wat.logic.service.utils;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wat.db.domain.conversation.Conversation;
import pl.wat.db.domain.conversation.PrivateMessage;
import pl.wat.db.domain.dictionary.SimpleDictionary;
import pl.wat.db.domain.event.Event;
import pl.wat.db.domain.event.Localization;
import pl.wat.db.domain.event.Participant;
import pl.wat.db.domain.localization.City;
import pl.wat.db.domain.localization.Region;
import pl.wat.db.domain.user.Authority;
import pl.wat.db.domain.user.User;
import pl.wat.db.domain.user.profile.attributes.*;
import pl.wat.db.domain.user.profile.attributes.Dictionary;
import pl.wat.logic.dto.conversation.ConversationDTO;
import pl.wat.logic.dto.conversation.PrivateMessageDTO;
import pl.wat.logic.dto.dictionary.SimpleDictionaryDTO;
import pl.wat.logic.dto.event.EventDTO;
import pl.wat.logic.dto.event.LocalizationDTO;
import pl.wat.logic.dto.event.ParticipantDTO;
import pl.wat.logic.dto.localization.CityDTO;
import pl.wat.logic.dto.localization.RegionDTO;
import pl.wat.logic.dto.profile.ProfilePictureDTO;
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
            dto.setLastpassres(entity.getLastpassres());
            dto.setEnabled(entity.getEnabled());
            dto.setAuthorities((entity.getAuthorities()));
            dto.setAge(this.countAge(entity));
            dto.setProfilePhotoId(entity.getProfilePhotoId());
            dto.setAccountCreateDate(entity.getAccountCreateDate());
            dto.setLastLogoutDate(entity.getLastLogoutDate());
            dto.setBirthDate(entity.getBirthDate());
            dto.setCity(toDTO(entity.getCity()));
            dto.setDescription(entity.getDescription());
            dto.setDrinking(entity.getDrinking());
            dto.setEducation(toDTO(entity.getEducation()));
            dto.setEyeColor(toDTO(entity.getEyeColor()));
            dto.setFigure(toDTO(entity.getFigure()));
            dto.setHairColor(toDTO(entity.getHairColor()));
            dto.setHeight(dto.getHeight());
            dto.setKids(dto.getKids());
            dto.setMan(dto.isMan());
            dto.setMartialStatus(toDTO(entity.getMartialStatus()));
            dto.setProfession(entity.getProfession());
            dto.setReligion(toDTO(entity.getReligion()));
            dto.setSmoking(entity.getSmoking());
            dto.setZodiacSign(toDTO(entity.getZodiacSign()));


            return dto;
        }else {
            return null;
        }
    }

    @Transactional(readOnly = true)
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
            dto.setEnabled(false);
            dto.setAuthorities(toDTO(entity.getAuthorities()));
            dto.setAge(this.countAge(entity));
            dto.setProfilePhotoId(entity.getProfilePhotoId());
            return dto;
        }else {
            return null;
        }
    }

    public UserDTO toSimpleParticipantDto(User entity){
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
            dto.setEnabled(false);
            dto.setAuthorities(null);
            dto.setAge(this.countAge(entity));
            dto.setProfilePhotoId(entity.getProfilePhotoId());
            return dto;
        }else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<Authority> toDTO(List<Authority> entity){
        return entity;
    }

    public User toEntity(UserDTO dto){
        if(dto !=null){
            User entity = new User();
            entity.setId(dto.getId());
            entity.setUsername(dto.getUsername());
            entity.setPassword(dto.getPassword());
            entity.setEmail(dto.getEmail());
            entity.setFirstname(dto.getFirstname());
            entity.setLastname(dto.getLastname());
            entity.setBirthDate(dto.getBirthDate());
            entity.setCity(toEntity(dto.getCity()));
            entity.setDescription(dto.getDescription());
            entity.setDrinking(dto.getDrinking());
            entity.setEducation((Education)toEntity(dto.getEducation()));
            entity.setEyeColor((EyeColor)toEntity(dto.getEyeColor()));
            entity.setFigure((Figure)toEntity(dto.getFigure()));
            entity.setHairColor((HairColor)toEntity(dto.getHairColor()));
            entity.setMartialStatus((MartialStatus)toEntity(dto.getMartialStatus()));
            entity.setReligion((Religion)toEntity(dto.getReligion()));
            entity.setZodiacSign((ZodiacSign)toEntity(dto.getZodiacSign()));
            entity.setHeight(dto.getHeight());
            entity.setKids(dto.getKids());
            entity.setMan(dto.isMan());
            entity.setProfession(dto.getProfession());
            entity.setProfilePhotoId(dto.getProfilePhotoId());
            entity.setSmoking(dto.getSmoking());
            entity.setEnabled(dto.isEnabled());
            entity.setAuthorities(dto.getAuthorities());
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


    public EventDTO toSimpleDTO(Event event){
        if(event!=null){
            EventDTO dto = new EventDTO();
            dto.setTitle(event.getTitle());
            dto.setId(event.getId());
            dto.setEventStart(event.getEventStart());
            dto.setDescription(event.getDescription());
            dto.setCapacity(event.getCapacity());
            dto.setLocalization(toDTO(event.getLocalization()));
            dto.setOrganizer(null);
            dto.setEnabled(event.isEnabled());
            return dto;
        }
        else
            return null;
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
            dto.setOrganizer(toSimpleDto(event.getOrganizer()));
            dto.setEnabled(event.isEnabled());
            return dto;
        }
        else
            return null;
    }

    public Event toEntity(EventDTO eventDTO){
        if(eventDTO!=null){
            Event event = new Event();
            if (eventDTO.getId()!=null) event.setId(eventDTO.getId());
            event.setDescription(eventDTO.getDescription());
            event.setCapacity(eventDTO.getCapacity());
            event.setEventStart(eventDTO.getEventStart());
            event.setTitle(eventDTO.getTitle());
            event.setLocalization(toEntity(eventDTO.getLocalization()));
            event.setOrganizer(toEntity(eventDTO.getOrganizer()));
            event.setEnabled(eventDTO.isEnabled());
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
            if(cityDTO.getId()!=null) city.setId(cityDTO.getId());
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
            if(regionDTO.getId()!=null) entity.setId(regionDTO.getId());
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
            if(dto.getId()!=null) entity.setId(dto.getId());
            entity.setCity(toEntity(dto.getCity()));
            entity.setAddress(dto.getAddress());
            entity.setGeoLength(dto.getGeoLength());
            entity.setGeoWidth(dto.getGeoWidth());
            return entity;
        }else
            return null;
    }

    public List<ParticipantDTO> toSimpleDTOList(List<Participant> entities){
        List<ParticipantDTO> dtos = new LinkedList<>();
        if(entities!= null && entities.size()>0){

            entities.forEach(e->{
                dtos.add(toDTO(e));
            });
        }
        return dtos;
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
            if(dto.getId()!=null) entity.setId(dto.getId());
            entity.setUser(toEntity(dto.getUser()));
            entity.setEvent(toEntity(dto.getEvent()));
            return entity;
        }
        else
            return null;
    }

    public Dictionary toEntity(SimpleDictionaryDTO dto){
        if(dto!=null){
            Dictionary entity = new Dictionary();
            if(dto.getId()!=null) entity.setId(dto.getId());
            entity.setDescription(dto.getDescription());
            return entity;
        }
        else
            return null;
    }

    public SimpleDictionaryDTO toDTO(Dictionary entity){
        if(entity!=null){
            SimpleDictionaryDTO dto = new SimpleDictionaryDTO();
            dto.setId(entity.getId());
            dto.setDescription(entity.getDescription());
            return dto;
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
