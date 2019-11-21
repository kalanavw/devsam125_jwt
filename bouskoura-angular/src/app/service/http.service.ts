import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, map} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders(),
  withCredentials: false
};

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private baseUrl = 'http://localhost:3535/';

  constructor(private http: HttpClient) {
  }

  httpGet(endpoint: any): Observable<any> {
    const url = this.baseUrl.concat(endpoint);
    return this.http.get(url, httpOptions)
      .pipe(
        map(res => {
          return res;
        }),
        catchError(this.handleError('res'))
      );
  }

  httpPost(endpoint: any, body: any): Observable<any> {
    const url = this.baseUrl.concat(endpoint);

    return this.http.post(url, body, httpOptions)
      .pipe(
        map(res => {
          return res;
        })
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log(`${operation} failed: ${error.message}`);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
