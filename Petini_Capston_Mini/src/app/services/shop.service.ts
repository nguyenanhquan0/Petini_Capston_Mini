import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs/internal/observable/throwError';
import { catchError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ShopService {
  constructor(private httpClient: HttpClient) {}
  private REST_API_SERVER = 'http://localhost:8080';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      //'Authorization': 'my-auth-token'
    }),
  };
  private handleError(error: HttpErrorResponse) {
    return throwError(
      error.error["message"]);
  };

  // Get Items List
  public getItems(){
    const url =`${this.REST_API_SERVER}/api/product/list`;
    return this.httpClient
    .get<any>(url,this.httpOptions)
    .pipe(catchError(this.handleError));
  }
}
