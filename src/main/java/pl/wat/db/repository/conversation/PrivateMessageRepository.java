package pl.wat.db.repository.conversation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import pl.wat.db.domain.conversation.Conversation;
import pl.wat.db.domain.conversation.PrivateMessage;

import java.util.List;

public interface PrivateMessageRepository extends CrudRepository<PrivateMessage, Long> {
    //   Page<PrivateMessage> findByConversationOrderBySendDateAsc(Conversation conversation, Pageable page);

    List<PrivateMessage> findLast10ByConversationIdAndIdLessThanOrderBySendDateAsc(Long conversationId,Long id);
    List<PrivateMessage> findAllByConversationIdAndIdGreaterThanOrderBySendDateAsc(Long conversationId,Long id);


    List<PrivateMessage> findFirst10ByConversationIdAndIdLessThanOrderBySendDateDesc(Long conversationId,Long id);
    List<PrivateMessage> findFirst10ByConversationIdOrderBySendDateDesc(Long conversationId);

    List<PrivateMessage> getFirst1ByConversationIdOrderBySendDateDesc(Long conversationId);
}
