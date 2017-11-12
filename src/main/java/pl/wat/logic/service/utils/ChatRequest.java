package pl.wat.logic.service.utils;

import pl.wat.logic.dto.conversation.ConversationDTO;

public class ChatRequest {
    public int conversationId;
    public ConversationDTO conversation;
    public int messageId;
    public String messageText;
}
