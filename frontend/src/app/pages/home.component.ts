import {Component, OnInit, OnDestroy} from '@angular/core';

import { User } from '../models/user';
import {AuthenticationService} from "../services/authentication.service";
import {Subscription} from "rxjs";

@Component({
    templateUrl: './home.component.html'
})

export class HomeComponent implements OnInit, OnDestroy {

    currentUser: User;
    subscription: Subscription;

    constructor(private authService: AuthenticationService) {
    }

    ngOnInit() {
        this.subscription = this.authService.user$.subscribe(user => this.currentUser = user);
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
    }

    test() {
      this.authService.test()
        .subscribe(
          data => {
            console.log(data);
          },
          error => {
            console.log(error);
          });
    }
}
