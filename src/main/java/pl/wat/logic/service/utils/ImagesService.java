package pl.wat.logic.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.db.domain.user.profile.ProfilePicture;
import pl.wat.db.repository.user.profile.ProfilePictureRepository;
import pl.wat.logic.dto.profile.ProfilePictureDTO;

import java.util.LinkedList;
import java.util.List;

@Service
public class ImagesService {

    @Autowired
    private ProfilePictureRepository profilePictureRepository;

    @Autowired
    private TransformService tSrv;
    public List<ProfilePictureDTO> getUserPicturesList(int userId){
        List<ProfilePicture> fetched = profilePictureRepository.findAllByUserId(userId);
        List<ProfilePictureDTO> dtos = new LinkedList<>();
        if(fetched != null){
            fetched.forEach(pic -> dtos.add(tSrv.toDTO(pic)));
        }
        return  dtos;
    }
}
