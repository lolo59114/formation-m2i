import { Injectable } from '@angular/core';
import {User} from "../types/user";
import {catchError, map, Observable, of, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  register(user: Partial<User>): Observable<User> {
    return this.http.post<User>(environment.apiUrl + "/register", user).pipe(
      catchError(err => {
        alert(err?.message);
        return of();
      })
    );
  }

  login(cred: Pick<User, "email" | "password">): Observable<string> {
    return this.http.post<{ accessToken: string }>(environment.apiUrl + "/login", cred).pipe(
      tap(resp => localStorage.setItem("token", resp.accessToken)),
      map(resp => resp.accessToken),
      catchError(err => {
        alert(err?.message);
        return of();
      })
    )
  }

  getToken(): string | null {
    return localStorage.getItem("token");
  }

}
