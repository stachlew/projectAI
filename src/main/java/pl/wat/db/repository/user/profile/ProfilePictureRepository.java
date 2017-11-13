package pl.wat.db.repository.user.profile;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.user.profile.ProfilePicture;

import java.util.List;

public interface ProfilePictureRepository extends CrudRepository<ProfilePicture, Integer> {
    List<ProfilePicture> findAllByUserId(int userId);
}
