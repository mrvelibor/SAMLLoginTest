import {Component} from '@angular/core';
import { Router } from '@angular/router';

import { AlertService } from '../services/alert.service';
import {AuthenticationService} from "../services/authentication.service";

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent {
    model: any = {};
    loading: boolean;

    constructor(
        private router: Router,
        private loginService: AuthenticationService,
        private alertService: AlertService) { }

    login() {
        this.loading = true;
        this.alertService.clearMessage();
        this.loginService.login(this.model.username, this.model.password)
            .subscribe(
                data => {
                    console.log(data);

                    this.alertService.success('Login successful!', true);

                    let user = data;
                    if(user.type == 1) {
                        this.router.navigate(['/tom']);
                    }
                    else if(user.type == 2) {
                        this.router.navigate(['/jerry']);
                    }
                    else {
                        this.router.navigate(['/']);
                    }
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
