package pl.wat.db.repository.personality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.personality.CategoryAttribute;
import pl.wat.db.domain.personality.Match;
import pl.wat.db.domain.personality.PersonalityCategory;
import pl.wat.db.domain.personality.UserPersonalityAttribute;
import pl.wat.db.domain.user.User;

import java.util.List;

public interface UserPersonalityAttributeRepository extends JpaRepository<UserPersonalityAttribute, Long> {

    @Query(value = "select calc_query.DESCRIPTION, (round(calc_query.matches/pc1.AMOUNT, 2)) * 100 percentage from (\n" +
            "select pc.DESCRIPTION, count(*) as matches from personality_category pc\n" +
            "join category_attribute ca\n" +
            "on pc.id = ca.category_id\n" +
            "where ca.id in (\n" +
            "select attribute_id from user_personality_attr out_query\n" +
            "where exists (\n" +
            "    select 1 from user_personality_attr in_query\n" +
            "        where out_query.PARTNER_ANSWER = in_query.ANSWER\n" +
            "        and user_id = ?2 -- moja wymarzona druga polowa\n" +
            "    )\n" +
            "and user_id = ?1 -- ja\n" +
            ")\n" +
            "group by pc.DESCRIPTION\n" +
            ") calc_query join personality_category pc1 on pc1.DESCRIPTION = calc_query.DESCRIPTION",nativeQuery = true)
    public List<Object[]> findMatchUserIdOneToUserIdTwo(Long idOne, Long idTwo);

    List<UserPersonalityAttribute> findFirstByUser(User user);
    List<UserPersonalityAttribute> findByUserAndCategoryAttribute_PersonalityCategory(User user, PersonalityCategory personalityCategory);
}
