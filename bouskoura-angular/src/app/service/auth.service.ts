import {Injectable} from '@angular/core';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router: Router) {
  }

  public getToken(): string {
    return localStorage.getItem('token');
  }

  public setToken(token: any) {
    localStorage.setItem('token', token);
  }

  public deleteToken() {
    localStorage.removeItem('token');
  }

  public logout() {
    this.deleteToken();
    this.router.navigate(['/']);
  }
}
