import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";

@Component({
  selector: 'app-observables',
  standalone: true,
  imports: [],
  templateUrl: './observables.component.html',
  styleUrl: './observables.component.css'
})
export class ObservablesComponent implements OnInit {

  data$ = new Observable<string>(observer => {
    observer.next("Hello world");
  });

  ngOnInit() {
    this.data$.subscribe({
      next: (value) => { console.log(value); },
      error: (error) => { console.log(error); },
      complete: () => { console.log("Terminé"); }
    });
  }

}
