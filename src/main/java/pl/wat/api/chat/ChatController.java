package pl.wat.api.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.wat.logic.dto.conversation.ConversationDTO;
import pl.wat.logic.dto.conversation.PrivateMessageDTO;
import pl.wat.logic.service.conversation.ConversationService;
import pl.wat.logic.service.utils.ChatRequest;
import pl.wat.logic.service.utils.UtilService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    ConversationService conversationService;

    @Autowired
    UtilService utilService;

    //lista rozmow
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/getAllMessages",method = RequestMethod.GET)
    public @ResponseBody
    List<ConversationDTO> getAllConversations(Authentication auth){
        int userId = this.utilService.getUserId(auth);
        if(userId>0){
            return this.conversationService.getAllConversationsByUser(userId);
        }else {
            return null;
        }
    }

    //ostatnie 10 wypowiedzi
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/getLastMessages",method = RequestMethod.POST)
    public @ResponseBody
    List<PrivateMessageDTO> getLastMessages(Authentication auth, @RequestBody ChatRequest request){
        int userId = this.utilService.getUserId(auth);
        if(conversationService.isConversationOwner(request.conversationId,userId)){
            return this.conversationService.getLatestMessages(request.conversationId);
        }else {
            return null;
        }
    }


    //poprzednie 10 wypowiedzi
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/getMessagesBefore",method = RequestMethod.POST)
    public @ResponseBody
    List<PrivateMessageDTO> getMessagesBefore(Authentication auth, @RequestBody ChatRequest request){
        int userId = this.utilService.getUserId(auth);
        if(conversationService.isConversationOwner(request.conversationId,userId)){
            return this.conversationService.getMessagesBefore(request.conversationId, request.messageId);
        }else {
            return null;
        }
    }

    //wszystkie najnowsze wypowiedzi
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/getMessagesAfter",method = RequestMethod.POST)
    public @ResponseBody
    List<PrivateMessageDTO> getMessagesAfter(Authentication auth, @RequestBody ChatRequest request){
        int userId = this.utilService.getUserId(auth);
        if(conversationService.isConversationOwner(request.conversationId,userId)){
            return this.conversationService.getMessagesAfter(request.conversationId, request.messageId);
        }else {
            return null;
        }
    }

    //dodanie wypowiedzi
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/sendNewMessage",method = RequestMethod.POST)
    public @ResponseBody
    PrivateMessageDTO sendNewMessage(Authentication auth, @RequestBody ChatRequest request){
        int userId = this.utilService.getUserId(auth);
        if(conversationService.isConversationOwner(request.conversation.getId(),userId)){
            return this.conversationService.addPrivateMessagesToConversation(request.conversation, userId, request.messageText);
        }else {
            return null;
        }
    }

    //nawiazanie rozmowy
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/createNewConversation",method = RequestMethod.POST)
    public @ResponseBody
    ConversationDTO createNewConversation(Authentication auth, @RequestBody int receiverId){
        int userId = this.utilService.getUserId(auth);
        if(userId>0){
            return this.conversationService.createConversation(userId, receiverId);
        }else {
            return null;
        }
    }
}
