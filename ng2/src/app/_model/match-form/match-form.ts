import {UserPersonalityAttribute} from "./user-personality-attribute";
import {User} from "../user.model";

export class MatchForm{
  user: User;
  characterList: UserPersonalityAttribute[];
  personalityList: UserPersonalityAttribute[];
  freeTimeList: UserPersonalityAttribute[];
}
