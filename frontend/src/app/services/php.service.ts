import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map'

@Injectable()
export class PhpService {

  protected static _host: string = "http://localhost:8080";

  constructor(protected http: Http) {
  }

  protected static createOptions(token = null) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    if (token) {
      headers.append('X-Auth-Token', token)
    }
    return new RequestOptions({headers: headers, withCredentials: true});
  }

}
