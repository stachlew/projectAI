import {Conversation} from "./conversation";
import {User} from "./user.model";

export class PrivateMessage{
  id:number;
  conversation: Conversation;
  sendDate: Date;
  sender: User;
  textMessage: string;
}
