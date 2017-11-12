package pl.wat.logic.service.conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.db.domain.conversation.Conversation;
import pl.wat.db.domain.conversation.PrivateMessage;
import pl.wat.db.repository.conversation.ConversationRepository;
import pl.wat.db.repository.conversation.PrivateMessageRepository;
import pl.wat.db.repository.user.UserRepository;
import pl.wat.logic.dto.conversation.ConversationDTO;
import pl.wat.logic.dto.conversation.PrivateMessageDTO;
import pl.wat.logic.service.utils.TransformService;

import java.util.LinkedList;
import java.util.List;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;
    @Autowired
    private PrivateMessageRepository privateMessageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransformService tSrv;

    public PrivateMessageDTO addPrivateMessagesToConversation(ConversationDTO conversation, int idUser, String textMessage){
        PrivateMessage privateMessage = new PrivateMessage(tSrv.toEntity(conversation),userRepository.findOne(idUser),textMessage);
        return tSrv.toDTO(privateMessageRepository.save(privateMessage));
    }

    public ConversationDTO createConversation(int idUserOne, int idUserTwo){
        Conversation conversation = conversationRepository.findExistxConversation(userRepository.findOne(idUserOne), userRepository.findOne(idUserTwo));
        if (conversation == null) {
            conversation = conversationRepository.save(
                    new Conversation(userRepository.findOne(idUserOne), userRepository.findOne(idUserTwo))
            );
        }
        return tSrv.toDTO(conversation);
    }

    public List<ConversationDTO> getAllConversationsByUser(int idUser){
        List<Conversation> fetched = conversationRepository.getAllByMemberOneIdOrMemberTwoId(idUser, idUser);
        List<ConversationDTO> dtos = new LinkedList<>();
        if(fetched!=null){
            fetched.forEach( conversation -> dtos.add(tSrv.toDTO(conversation)));
        }
        dtos.forEach(conv -> {
            if(conv.getMemberOne().getId() == idUser){
                conv.setSecondPerson(conv.getMemberTwo());
            }else {
                conv.setSecondPerson(conv.getMemberOne());
            }
        });
        return dtos;
    }

    public List<PrivateMessageDTO> getLatestMessages(int idConversation){
        List<PrivateMessage> fetched = privateMessageRepository.findLast10ByConversationIdOrderBySendDateAsc(idConversation);
        return transformMessageData(fetched);
    }

    public List<PrivateMessageDTO> getMessagesAfter(int idConversation, int idMessage){
        List<PrivateMessage> fetched = privateMessageRepository.findAllByConversationIdAndIdGreaterThanOrderBySendDateAsc(idConversation, idMessage);
        return transformMessageData(fetched);
    }

    public List<PrivateMessageDTO> getMessagesBefore(int idConversation, int idMessages){
        List<PrivateMessage> fetched = privateMessageRepository.findLast10ByConversationIdAndIdLessThanOrderBySendDateAsc(idConversation,idMessages);
        return transformMessageData(fetched);
    }

    private List<PrivateMessageDTO> transformMessageData(List<PrivateMessage> entity){
        List<PrivateMessageDTO> dtos = new LinkedList<>();
        if(entity!=null){
            entity.forEach( msg -> dtos.add(tSrv.toDTO(msg)));
        }
        return dtos;
    }

    public boolean isConversationOwner(int conversationId, int userId){
        if(conversationRepository.findOneByIdAndMemberOneOrMemberTwo(conversationId,userRepository.findOne(userId)) != null){
            return true;
        }
        else
            return false;
    };
}
