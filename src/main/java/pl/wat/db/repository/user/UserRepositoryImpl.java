package pl.wat.db.repository.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import pl.wat.db.domain.user.User;
import pl.wat.logic.dto.profile.ProfileSearchDTO;

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
    public Slice<User> findUsersByFilter(ProfileSearchDTO filter, Pageable pageable) {

        int firstElem = pageable.getPageNumber() * pageable.getPageSize();

        Query queryCount = makeQuery(filter);
        List resultList = queryCount.getResultList();
        filter.setCountElements(resultList.size());
        filter.setCountPage((int) Math.ceil((double)resultList.size()/(double)pageable.getPageSize()));

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

    private Query makeQuery(ProfileSearchDTO filter){

        //prawdziwy sql
        StringBuilder queryBuilder = new StringBuilder("SELECT u FROM User u WHERE id!=:id ");
        Map<String, Object> params = new TreeMap<String, Object>();

        params.put("id",filter.id);

        //jesli filtr to obiekt i ma jakies parametry, sprawdza sie czy nie jest taki parametr pusty i dokleja do zapytania jak DymamSQL
//        (isNotEmpty(filter.login) ? " and LOWER(u.login) like CONCAT('%', :login, '%') ":"")
        //powyzej widac tez przyklad parametru wypelnianego wartoscia nizej
        if(filter.city != null){
            queryBuilder.append(" and city_id = :city_id");
            params.put("city_id",filter.city.getId());
        }

        if(filter.region !=null){
            queryBuilder.append(" and city.region.id = :region_id");
            params.put("region_id",filter.getRegion().getId());
        }

        if(filter.ageFrom > 0){
            //queryBuilder.append(" and birth_date < sysdate - ( :ageFrom *365)");
            queryBuilder.append(" and birth_date < add_months(sysdate , :ageFrom * (-12))");
            params.put("ageFrom",filter.ageFrom);
        }

        if(filter.ageTo >0 ){
            queryBuilder.append(" and birth_date > add_months(sysdate , :ageTo * (-12))");
            params.put("ageTo",filter.ageTo);
        }

        if(filter.isMan != null && !filter.isMan.isEmpty()){
            if (filter.isMan.equals('M')){
                queryBuilder.append(" and is_man = 1");
            }
            else {
                queryBuilder.append(" and is_man =0");
            }
        }

        if(filter.kids !=null &&!filter.kids.isEmpty()){
            queryBuilder.append(" and upper(kids) = upper(:kids)");
            params.put("kids",filter.kids);
        }

        if(filter.drinking !=null && !filter.drinking.isEmpty()){
            queryBuilder.append(" and upper(drinking)=upper(:drinking)");
            params.put("drinking",filter.drinking);
        }

        if (filter.smoking !=null && !filter.smoking.isEmpty()){
            queryBuilder.append(" and upper(smoking)=upper(:smoking)");
            params.put("smoking",filter.smoking);
        }

        if(filter.education != null){
            queryBuilder.append(" and education_id = :education_id");
            params.put("education_id",filter.education.getId());
        }


        //ustawienie parametrow
//        Map<String, Object> params = new TreeMap<String, Object>();
//        if(isNotEmpty(filter.firstName))
//            params.put("login", jakasWartoscString.toLowerCase());




        //Wypelnienie mapy
        Query query = em.createQuery(queryBuilder.toString());
      for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }

        return query;
    }

}
