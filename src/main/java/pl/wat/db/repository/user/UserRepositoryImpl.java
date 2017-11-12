package pl.wat.db.repository.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import pl.wat.db.domain.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Slice<User> findUsersByFilter(String filter, Pageable pageable) {

        int firstElem = pageable.getPageNumber() * pageable.getPageSize();

        Query query = makeQuery(filter);
        query.setFirstResult(firstElem);
        query.setMaxResults(pageable.getPageSize());
        List<User> result = query.getResultList();

        if (result == null) {
            return new SliceImpl<User>(new ArrayList<User>());
        } else {
            return new SliceImpl<User>(result, pageable, true);
        }
    }

    private Query makeQuery(String filter){

        //prawdziwy sql
        StringBuilder queryBuilder = new StringBuilder("SELECT u FROM User u left join ...");

        //jesli filtr to obiekt i ma jakies parametry, sprawdza sie czy nie jest taki parametr pusty i dokleja do zapytania jak DymamSQL
//        (isNotEmpty(filter.login) ? " and LOWER(u.login) like CONCAT('%', :login, '%') ":"")
        //powyzej widac tez przyklad parametru wypelnianego wartoscia nizej

        //ustawienie parametrow
//        Map<String, Object> params = new TreeMap<String, Object>();
//        if(isNotEmpty(filter.firstName))
//            params.put("login", jakasWartoscString.toLowerCase());

        //Wypelnienie mapy
        Query query = em.createQuery(queryBuilder.toString());
//        for (String key : params.keySet()) {
//            query.setParameter(key, params.get(key));
//        }

        return query;
    }

}
