package pl.wat.db.repository.conversation;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.conversation.Conversation;


public interface ConversationRepository  extends CrudRepository<Conversation, Integer> {

}
