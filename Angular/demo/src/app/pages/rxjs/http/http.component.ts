import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-http',
  standalone: true,
  imports: [],
  templateUrl: './http.component.html',
  styleUrl: './http.component.css'
})
export class HttpComponent implements OnInit {
  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get('https://jsonplaceholder.typicode.com/users').subscribe(
      {
        next: (value) => { console.log(value); },
        error: (error) => { console.log(error); },
        complete: () => { console.log("Données récupérées"); }
      }
    )
  }
}
