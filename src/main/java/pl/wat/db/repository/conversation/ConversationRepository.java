package pl.wat.db.repository.conversation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.conversation.Conversation;

import java.util.List;


public interface ConversationRepository  extends JpaRepository<Conversation, Integer> {
    List<Conversation> getAllByMemberOneIdOrMemberTwoId(int idUser, int idUser2);

    List<Conversation> getAllByMemberOneIdAndMemberTwoId(int oneId, int twoId);
}
