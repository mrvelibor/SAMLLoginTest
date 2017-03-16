import {Component, OnInit, OnDestroy} from '@angular/core';
import {User} from "./models/user";
import {AuthenticationService} from "./services/authentication.service";
import {Router} from "@angular/router";
import {AlertService} from "./services/alert.service";
import {Subscription} from "rxjs/Subscription";
import {OverlayService} from "./services/overlay.service";

@Component({
    selector: 'app',
    templateUrl: './app.component.html'
})

export class AppComponent implements OnInit, OnDestroy {

    subscription: Subscription;
    loading: boolean;

    currentUser: User;

    constructor(private authService: AuthenticationService,
                private alertService: AlertService,
                private overlayService: OverlayService,
                private router: Router){
    }

    ngOnInit() {
        this.subscription = this.authService.user$.subscribe(user => this.currentUser = user);
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
    }

    logout() {
        this.loading = true;
        this.alertService.clearMessage();
        this.overlayService.showMessage("Logging out...");
        this.authService.logout()
            .subscribe(
                data => {
                    this.alertService.success(data, true);
                    this.loading = false;
                    this.overlayService.clearMessage();
                    this.router.navigate(['/']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                    this.overlayService.clearMessage();
                }
            )
    }
}