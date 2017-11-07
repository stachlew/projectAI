package pl.wat.logic.service.profile;

import org.springframework.stereotype.Service;
import pl.wat.db.domain.user.profile.Profile;
import pl.wat.logic.dto.profile.ProfileDTO;

@Service
public class ProfileService {

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


    //Inne metody związane z profilem
}
