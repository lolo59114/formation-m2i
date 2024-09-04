import { Component } from '@angular/core';
import {OrdertablePipe} from "../../utils/ordertable.pipe";
import {TitleCasePipe} from "@angular/common";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-series',
  standalone: true,
  imports: [
    OrdertablePipe,
    TitleCasePipe
  ],
  templateUrl: './series.component.html',
  styleUrl: './series.component.css'
})
export class SeriesComponent {
  series: string[] = [
    "stranger things",
    "Evil",
    "The Walking Dead",
    "Breaking Bad",
  ];

  order: 'ASC' | 'DESC' = 'ASC';

  toggleOrder() {
    this.order = this.order == 'ASC' ? 'DESC' : 'ASC';
  }
}
