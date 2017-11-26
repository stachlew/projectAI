package pl.wat.db.repository.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.wat.db.domain.user.User;
import pl.wat.logic.dto.profile.ProfileSearchDTO;

public interface UserRepositoryCustom {

    //interfejs do metody wyszukiwania z palca za pomocą SQL
    Slice<User> findUsersByFilter(ProfileSearchDTO filter, Pageable pageable);

    //HQL
//    @Query(value = "SELECT USER FROM users u WHERE ...",nativeQuery = true)
//    User findUserBySomethingElse(@Param("someId") int someId);
}
