import {Component, OnInit} from '@angular/core';
import {ChucknorrisService} from "../../services/chucknorris.service";
import {Fact} from "../../types/fact";

@Component({
  selector: 'app-chucknorris',
  standalone: true,
  imports: [],
  templateUrl: './chucknorris.component.html',
  styleUrl: './chucknorris.component.css'
})
export class ChucknorrisComponent implements OnInit {

  fact?: Fact;
  factString: string = '';

  constructor(private chucknorrisService: ChucknorrisService) {
  }

  // Avec type Fact
  ngOnInit() {
    this.chucknorrisService.getAJoke().subscribe(response => this.fact = response);
  }

  // Avec la value en string
  // ngOnInit() {
  //   this.chucknorrisService.getAJoke().subscribe(response => this.factString = response);
  // }

  // Avec type Fact
  reload() {
    this.chucknorrisService.getAJoke().subscribe(response => this.fact = response);
  }

  // Avec la value en string
  // reload() {
  //   this.chucknorrisService.getAJoke().subscribe(response => this.factString = response);
  // }
}
