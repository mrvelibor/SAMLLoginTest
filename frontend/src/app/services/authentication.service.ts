import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {CookieService} from 'angular2-cookie/core';
import 'rxjs/add/operator/map'
import {PhpService} from "./php.service";
import {BehaviorSubject} from "rxjs";
import {User} from "../models/user";
import { Observable } from "rxjs/Observable";

@Injectable()
export class AuthenticationService extends PhpService {

  private _userSource;
  private _user;
  user$;

  constructor(http: Http) {
    super(http);
    let user = JSON.parse(localStorage.getItem('user'));
    this._userSource = new BehaviorSubject<User>(user);
    this.user$ = this._userSource.asObservable();
    this.user$.subscribe(user => this._user = user);
  }

  private handleResponse(res: Response) {
    let user = res.json();
    if (!user) {
      console.log(res);
      return;
    }
    localStorage.setItem('user', JSON.stringify(user));
    this._userSource.next(user);
    return user;
  }

  login(username, password) {
    let params = new User();
    params.username = username;
    params.password = password;
    let body = JSON.stringify(params);
    console.log(body);

    let options = PhpService.createOptions();
    return this.http.post(
      PhpService._host + '/login',
      body,
      options
    ).map((res: Response) => {
      return this.handleResponse(res);
    });
  }

  auth() {
    let options = PhpService.createOptions();
    return this.http.get(
      PhpService._host + '/auth',
      options
    ).map((res: Response) => {
      return this.handleResponse(res);
    });
  }

  logout() {
    let user = this._user;
    if(!user) {
      return;
    }

    let options = PhpService.createOptions(/*user.token*/);
    return this.http.get(
      PhpService._host + '/logout',
      options
    ).map((res: Response) => {
      console.log(res);
      localStorage.removeItem('user');
      this._userSource.next(null);
      return res;
    });
  }

  test() {
    let token = null;
    if(this._user) {
      token = this._user.token;
    }

    let options = PhpService.createOptions(token);
    return this.http.get(
      PhpService._host + '/protected/test',
      options
    ).map((res: Response) => {
      return res;
    });
  }
}
