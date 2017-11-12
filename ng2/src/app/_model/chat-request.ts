import {Conversation} from "./conversation";

export class ChatRequest{
  conversationId: number;
  conversation: Conversation;
  messageId: number;
  messageText: string;
}
