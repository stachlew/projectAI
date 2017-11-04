package pl.wat.db.repository.user.profile;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.user.profile.ProfilePicture;

public interface ProfilePictureRepository extends CrudRepository<ProfilePicture, Integer> {
}
