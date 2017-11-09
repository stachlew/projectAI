package pl.wat.logic.service.utils;

import org.springframework.stereotype.Service;
import pl.wat.db.domain.conversation.Conversation;
import pl.wat.db.domain.conversation.PrivateMessage;
import pl.wat.db.domain.user.Authority;
import pl.wat.db.domain.user.User;
import pl.wat.db.domain.user.profile.Profile;
import pl.wat.logic.dto.conversation.ConversationDTO;
import pl.wat.logic.dto.conversation.PrivateMessageDTO;
import pl.wat.logic.dto.profile.ProfileDTO;
import pl.wat.logic.dto.user.UserDTO;

import java.util.LinkedList;
import java.util.List;

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







}
