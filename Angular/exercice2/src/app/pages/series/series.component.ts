import { Component } from '@angular/core';

@Component({
  selector: 'app-series',
  standalone: true,
  imports: [],
  templateUrl: './series.component.html',
  styleUrl: './series.component.css'
})
export class SeriesComponent {
  series: string[] = [
    "Stranger things",
    "Evil",
    "The Walking Dead",
    "Breaking Bad",
  ];

  remove(index: number) {
    this.series.splice(index, 1);
  }
}
