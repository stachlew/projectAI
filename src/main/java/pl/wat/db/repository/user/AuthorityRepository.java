package pl.wat.db.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.db.domain.user.Authority;
import pl.wat.db.domain.user.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findFirstByName(AuthorityName name);
}
