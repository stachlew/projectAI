package pl.wat.db.repository.event;

import javax.persistence.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import pl.wat.db.domain.event.Event;
import pl.wat.logic.dto.event.EventSearchDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EventRepositoryImpl implements EventRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Slice<Event> findEventByFilter(EventSearchDTO filter, Pageable pageable) {

        int firstElem = pageable.getPageNumber() * pageable.getPageSize();

        Query queryCount = makeQuery(filter);
        List resultList = queryCount.getResultList();
        filter.setCountElements(resultList.size());
        filter.setCountPage((int) Math.ceil((double)resultList.size()/(double)pageable.getPageSize()));

        Query query = makeQuery(filter);
        query.setFirstResult(firstElem);
        query.setMaxResults(pageable.getPageSize());
        List<Event> result = query.getResultList();

        if (result == null) {
            return new SliceImpl<Event>(new ArrayList<Event>());
        } else {
            return new SliceImpl<Event>(result, pageable, true);
        }
    }

    private Query makeQuery(EventSearchDTO filter){

        //prawdziwy sql
        StringBuilder queryBuilder = new StringBuilder("SELECT e FROM Event e WHERE 1=1 AND ENABLED =1 ");
        Map<String, Object> params = new TreeMap<String, Object>();


        //jesli filtr to obiekt i ma jakies parametry, sprawdza sie czy nie jest taki parametr pusty i dokleja do zapytania jak DymamSQL
//        (isNotEmpty(filter.login) ? " and LOWER(u.login) like CONCAT('%', :login, '%') ":"")
        //powyzej widac tez przyklad parametru wypelnianego wartoscia nizej
        if(filter.getCity() != null){
            queryBuilder.append(" and localization.city.id = :city_id");
            params.put("city_id",filter.getCity().getId());
        }

        if(filter.getRegion()!=null){
            queryBuilder.append(" and localization.city.region.id = :region_id");
            params.put("region_id",filter.getRegion().getId());
        }


        if(filter.getDateFrom() != null){
            queryBuilder.append(" and event_start >= :dateFrom");
            params.put("dateFrom",filter.getDateFrom());
        }

        if(filter.getDateTo() != null){
            queryBuilder.append(" and event_start  < :dateTo ");
            params.put("dateTo",filter.getDateTo());
        }



        //Wypelnienie mapy
        Query query = em.createQuery(queryBuilder.toString());
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }

        return query;
    }

}
