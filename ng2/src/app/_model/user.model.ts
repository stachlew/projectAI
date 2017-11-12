export interface User {
  username: string;
  firstname: string;
  lastname: string;
  password: string;
  email: string;
  authorities: string[];
  enabled: boolean;
  age: number;
}
