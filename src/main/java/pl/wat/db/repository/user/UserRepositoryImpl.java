package pl.wat.db.repository.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import pl.wat.config.Constants;
import pl.wat.db.domain.user.Authority;
import pl.wat.db.domain.user.AuthorityName;
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
        StringBuilder queryBuilder = new StringBuilder("SELECT u FROM User u JOIN u.authorities auth JOIN u.city c JOIN c.region r WHERE u.id!=:id and auth.name=:role ");
        Map<String, Object> params = new TreeMap<String, Object>();

        params.put("id",filter.id);
        params.put("role", AuthorityName.ROLE_USER);

        //jesli filtr to obiekt i ma jakies parametry, sprawdza sie czy nie jest taki parametr pusty i dokleja do zapytania jak DymamSQL
//        (isNotEmpty(filter.login) ? " and LOWER(u.login) like CONCAT('%', :login, '%') ":"")
        //powyzej widac tez przyklad parametru wypelnianego wartoscia nizej




        if(filter.city != null){
            queryBuilder.append(" and c.id = :city_id");
            params.put("city_id",filter.city.getId());
        }else {
            if(filter.region !=null){
                queryBuilder.append(" and r.id = :region_id");
                params.put("region_id",filter.getRegion().getId());
            }
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

        if(filter.sex != null && !filter.sex.isEmpty()){
            if (filter.sex.equals("M")){
                queryBuilder.append(" and is_man = 1");
            }
            else {
                queryBuilder.append(" and is_man =0");
            }
        }


        if(filter.smoking != null){
            queryBuilder.append(" and smoking_id = :smoking_id");
            params.put("smoking_id",filter.smoking.getId());
        }

        if(filter.drinking != null){
            queryBuilder.append(" and drinking_id = :drinking_id");
            params.put("drinking_id",filter.drinking.getId());
        }

        if(filter.kids != null){
            queryBuilder.append(" and kids_id = :kids_id");
            params.put("kids_id",filter.kids.getId());
        }

        if(filter.education != null){
            queryBuilder.append(" and education_id = :education_id");
            params.put("education_id",filter.education.getId());
        }

        if(filter.zodiacSign != null){
            queryBuilder.append(" and zodiac_Sign_id = :zodiacSign_id");
            params.put("zodiacSign_id",filter.zodiacSign.getId());
        }

        if(filter.martialStatus != null){
            queryBuilder.append(" and martial_Status_id = :martialStatus_id");
            params.put("martialStatus_id",filter.martialStatus.getId());
        }

        if(filter.figure != null){
            queryBuilder.append(" and figure_id = :figure_id");
            params.put("figure_id",filter.figure.getId());
        }

        if(filter.hairColor != null){
            queryBuilder.append(" and hair_Color_id = :hairColor_id");
            params.put("hairColor_id",filter.hairColor.getId());
        }

        if(filter.eyeColor != null){
            queryBuilder.append(" and eye_Color_id = :eyeColor_id");
            params.put("eyeColor_id",filter.eyeColor.getId());
        }

        if(filter.religion != null){
            queryBuilder.append(" and religion_id = :religion_id");
            params.put("religion_id",filter.religion.getId());
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
