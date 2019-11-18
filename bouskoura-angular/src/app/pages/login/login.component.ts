import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpService} from '../../service/http.service';
import {AuthService} from '../../service/auth.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginForm: FormGroup;

  constructor(
    private router: Router,
    private httpService: HttpService,
    private authService: AuthService
  ) {
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }

  login() {
    const credentials = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password,
    };
    this.httpService.httpPost('login', credentials)
      .subscribe(res => {
        console.log(res);
        if (res) {
          const authorization = res.headers.get('Authorization');
          this.authService.setToken(authorization);
          const payload = JSON.parse(atob(authorization.split('.')[1]));
          const role = payload.roles[0];
          if (role === 'ADMIN') {
            this.router.navigate(['product-list']);
          } else if (role === 'USER') {
            this.router.navigate(['add-product']);
          } else {
            alert('role not found');
          }
        } else {
          // alert('login failed');
          console.log('login failed');
        }
      }, error => {
        console.log(error);
      });
  }
}
