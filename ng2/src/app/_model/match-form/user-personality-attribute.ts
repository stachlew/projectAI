import {User} from "../user.model";
import {CategoryAttribute} from "./category-attribute";

export class UserPersonalityAttribute{
  id: number;
  user: User;
  categoryAttribute: CategoryAttribute;
  answer: string;
  partnerAnswer: string;
}
