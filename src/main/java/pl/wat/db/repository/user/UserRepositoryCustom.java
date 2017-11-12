package pl.wat.db.repository.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.wat.db.domain.user.User;

public interface UserRepositoryCustom {

    //interfejs do metody wyszukiwania z palca za pomocą SQL
    Slice<User> findUsersByFilter(String filter,Pageable pageable);

    //HQL
//    @Query(value = "SELECT USER FROM users u WHERE ...",nativeQuery = true)
//    User findUserBySomethingElse(@Param("someId") int someId);
}
