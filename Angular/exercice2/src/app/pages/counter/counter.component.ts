import { Component } from '@angular/core';

@Component({
  selector: 'app-counter',
  standalone: true,
  imports: [],
  templateUrl: './counter.component.html',
  styleUrl: './counter.component.css'
})
export class CounterComponent {
  cpt: number = 0;

  addCounter(): void {
    this.cpt++;
  }

  removeCounter(): void {
    this.cpt--;
  }
}
