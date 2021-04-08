import { Component } from '@angular/core';
import { LoginService } from './login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'aula3-angular';
  isAuthenticated = false;

  constructor(loginService: LoginService) {
    loginService.isAuthenticated.asObservable()
        .subscribe(e => this.isAuthenticated = e);
  }

}
