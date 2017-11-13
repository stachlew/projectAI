import {Participant} from "./participant";
import {User} from "./user.model";
import {Localization} from "./localization";

export class SpeedDate{
  id:number;
  eventStart: Date;
  capacity: number;
  title: string;
  description: string;
  localization: Localization;
  organizer: User;
  isParticipant: boolean;
  participantList: Participant[];
}
