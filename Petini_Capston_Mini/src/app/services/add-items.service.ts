import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs/internal/observable/throwError';
import { catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddItemsService {
  private REST_API_SERVER = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) {}

  private httpOptions = {
    headers: new HttpHeaders({
       'Content-Type': 'application/json',
       'Authorization' :  'Bearer '+ localStorage.getItem('userToken')
    })
  };

  private handleError(error: HttpErrorResponse) {
    return throwError(
      error.error["message"]);
  };

  public addItems(
    products:Array<any>
    ) {
    var value = {
      products
    }
    const url =`${this.REST_API_SERVER}/api/product/add-list`;
    return this.httpClient
    .post<any>(url,value ,this.httpOptions)
    .pipe(catchError(this.handleError));
  }


}
