package pl.wat.logic.service.utils;

import pl.wat.logic.dto.conversation.ConversationDTO;

public class ChatRequest {
    public Long conversationId;
    public ConversationDTO conversation;
    public Long messageId;
    public String messageText;
}
