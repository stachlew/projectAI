package pl.wat.logic.domainServices.conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.db.domain.conversation.Conversation;
import pl.wat.db.domain.conversation.PrivateMessage;
import pl.wat.db.repository.conversation.ConversationRepository;
import pl.wat.db.repository.conversation.PrivateMessageRepository;
import pl.wat.db.repository.user.UserRepository;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;
    @Autowired
    private PrivateMessageRepository privateMessageRepository;
    @Autowired
    private UserRepository userRepository;

    public Conversation createConversation(int idUserOne, int idUserTwo){
        Conversation conversation = conversationRepository.save(
                new Conversation(
                        userRepository.findOne(idUserOne)
                        ,userRepository.findOne(idUserTwo)
                )
        );
        return conversation;
    }

    public PrivateMessage addPrivateMessagesToConversation(Conversation conversation,int idUser, String textMessage){
        PrivateMessage privateMessage = new PrivateMessage(conversation,userRepository.findOne(idUser),textMessage);

        return privateMessageRepository.save(privateMessage);
    }
}
