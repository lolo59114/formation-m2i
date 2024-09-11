import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {catchError, Observable, of} from "rxjs";
import {TrashBag} from "../types/trashbag";

@Injectable({
  providedIn: 'root'
})
export class TrashbagService {
  apiUrl = environment.apiUrl + "/trashBags";

  constructor(private http: HttpClient) { }

  getAll(): Observable<TrashBag[]> {
    return this.http.get<TrashBag[]>(this.apiUrl).pipe(
      catchError(err => {
        alert(err?.message);
        return of([] as TrashBag[]);
      })
    );
  }

  getOne(id: number): Observable<TrashBag> {
    return this.http.get<TrashBag>(`${this.apiUrl}/${id}`).pipe(
      catchError(err => {
        alert(err?.message);
        return of();
      })
    )
  }

  create(trashBag: Omit<TrashBag, "id">): Observable<TrashBag> {
    return this.http.post<TrashBag>(this.apiUrl, trashBag).pipe(
      catchError(err => {
        alert(err?.message);
        return of();
      })
    )
  }

  update(id: number, trashBag: Partial<TrashBag>): Observable<TrashBag> {
    return this.http.patch<TrashBag>(`${this.apiUrl}/${id}`, trashBag).pipe(
      catchError(err => {
        alert(err?.message);
        return of();
      })
    )
  }

  remove(id:number): Observable<boolean> {
    return this.http.delete<boolean>(`${this.apiUrl}/${id}`).pipe(
      catchError(err => {
        alert(err?.message);
        return of(false);
      })
    )
  }
}
