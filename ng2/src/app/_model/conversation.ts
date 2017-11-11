import {User} from "./user.model";
import {PrivateMessage} from "./private-message";

export class Conversation{
  id:number;
  memberOne: User;
  memberTwo: User;
  secondPerson: User;
  lastMessage: PrivateMessage;
}
