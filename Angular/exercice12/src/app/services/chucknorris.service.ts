import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Fact} from "../types/fact";
import {catchError, map, Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ChucknorrisService {
  apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  // Avec type Fact
  getAJoke(): Observable<Fact> {
    return this.http.get<Fact>(`${environment.apiUrl}/jokes/random`).pipe(
      catchError(err => {
        alert(err?.message);
        return of();
      })
    );
  }

  // Avec la value en string (c'est mieux avec un JSON)
  // getAJoke(): Observable<string> {
  //   return this.http.get<{value: string}>(`${environment.apiUrl}/jokes/random`).pipe(
  //     map((response: {value:string}) => {
  //       return response.value;
  //     }),
  //     catchError(err => {
  //       console.log(err);
  //       return of();
  //     })
  //   );
  // }
}
