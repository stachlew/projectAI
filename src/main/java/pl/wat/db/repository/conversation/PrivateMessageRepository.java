package pl.wat.db.repository.conversation;

import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.conversation.PrivateMessage;

public interface PrivateMessageRepository extends CrudRepository<PrivateMessage, Integer> {
}
