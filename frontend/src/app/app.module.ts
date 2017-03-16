import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import {HttpModule, JsonpModule} from '@angular/http';
import { AppComponent }  from './app.component';
import { routing }        from './app.routing';

import { AlertComponent } from './directives/alert.component';
import { UserMyGuard } from './guards/user_my.guard';
import { UserSamlGuard } from './guards/user_saml.guard';
import { AuthGuard } from './guards/auth.guard';
import { AlertService } from './services/alert.service';
import { LoginComponent } from './pages/login.component';
import {HomeComponent} from "./pages/home.component";
import {AuthenticationService} from "./services/authentication.service";
import { CookieService } from 'angular2-cookie/services/cookies.service';
import {PhpService} from "./services/php.service";
import {NospaceValidator} from "./directives/nospace.validator";
import {UserTypePipe} from "./directives/user_type.pipe";
import {DataTableModule} from "angular2-datatable";
import {OverlayService} from "./services/overlay.service";
import {OverlayComponent} from "./directives/overlay.component";
import {TomComponent} from "./pages/tom.component";
import {JerryComponent} from "./pages/jerry.component";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        JsonpModule,
        DataTableModule,
        routing
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        OverlayComponent,
        HomeComponent,
        LoginComponent,
        TomComponent,
        JerryComponent,
        NospaceValidator,
        UserTypePipe
    ],
    providers: [
        AuthGuard,
        UserMyGuard,
        UserSamlGuard,
        AlertService,
        OverlayService,
        CookieService,
        PhpService,
        AuthenticationService
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }