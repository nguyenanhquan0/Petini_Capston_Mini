import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient,
  HttpErrorResponse,
} from '@angular/common/http';
import { throwError } from 'rxjs/internal/observable/throwError';
import { catchError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ManageItemsService {
  constructor(private httpClient: HttpClient) {}
  private REST_API_SERVER = 'http://localhost:8080';
  private httpOptions = { headers: new HttpHeaders() };
  private handleError(error: HttpErrorResponse) {
    return throwError(error.error['message']);
  }

  // Get Items List
  public getListItems() {
    // headers
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        // Authorization: 'Bearer ' + localStorage.getItem('userToken'),
      }),
    };
    // get API
    const url = `${this.REST_API_SERVER}/api/product/list`;
    return this.httpClient
      .get<any>(url, this.httpOptions)
      .pipe(catchError(this.handleError));
  }

  public getItem(name: string) {
    // headers
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json ',
        // Authorization: 'Bearer ' + localStorage.getItem('userToken'),
      }),
    };
    // get API
    const url = `${this.REST_API_SERVER}/api/product/detail?name=${name}`;
    return this.httpClient
      .get<any>(url, this.httpOptions)
      .pipe(catchError(this.handleError));
  }
}
