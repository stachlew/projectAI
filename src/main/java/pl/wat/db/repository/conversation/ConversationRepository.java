package pl.wat.db.repository.conversation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.conversation.Conversation;
import pl.wat.db.domain.user.User;

import java.util.List;


public interface ConversationRepository  extends JpaRepository<Conversation, Long> {
    List<Conversation> getAllByMemberOneIdOrMemberTwoId(Long idUser, Long idUser2);

    List<Conversation> getAllByMemberOneIdAndMemberTwoId(Long oneId, Long twoId);

    @Query("select c from Conversation c where c.id =?1 and (c.memberOne = ?2 or c.memberTwo = ?2)")
    Conversation findOneByIdAndMemberOneOrMemberTwo(Long id, User user1);

    @Query("select c from Conversation c where (c.memberOne = ?1 and c.memberTwo =?2) or (c.memberOne = ?2 and c.memberTwo =?1)")
    Conversation findExistingConversation(User user1, User user2);
    // boolean findConversationByIdAndAndMemberOneOrMemberTwo(int id,User user);
}
