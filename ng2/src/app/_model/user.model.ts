export interface User {
  id: number
  username: string;
  firstname: string;
  lastname: string;
  password: string;
  email: string;
  authorities: string[];
  enabled: boolean;
  age: number;
  profilePhotoId: number;
}
