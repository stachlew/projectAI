package pl.wat.db.repository.conversation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.conversation.Conversation;
import pl.wat.db.domain.conversation.PrivateMessage;

import java.util.List;

public interface PrivateMessageRepository extends CrudRepository<PrivateMessage, Integer> {
    //   Page<PrivateMessage> findByConversationOrderBySendDateAsc(Conversation conversation, Pageable page);

    List<PrivateMessage> findLast10ByConversationIdAndIdLessThanOrderBySendDateAsc(int conversationId,int id);
    List<PrivateMessage> findAllByConversationIdAndIdGreaterThanOrderBySendDateAsc(int conversationId,int id);
    List<PrivateMessage> findLast10ByConversationIdOrderBySendDateAsc(int conversationId);
}
