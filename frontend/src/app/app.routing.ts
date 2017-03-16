import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './pages/login.component';
import { AuthGuard } from './guards/auth.guard';
import {HomeComponent} from "./pages/home.component";
import {TomComponent} from "./pages/tom.component";
import {JerryComponent} from "./pages/jerry.component";
import {UserMyGuard} from "./guards/user_my.guard";
import {UserSamlGuard} from "./guards/user_saml.guard";

const appRoutes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'tom', component: TomComponent, canActivate: [UserMyGuard] },
    { path: 'jerry', component: JerryComponent, canActivate: [UserSamlGuard] },
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);