import { Component } from '@angular/core';
import {DatePipe, DecimalPipe, LowerCasePipe, TitleCasePipe, UpperCasePipe} from "@angular/common";
import {RainbowPipe} from "../../utils/pipes/rainbow.pipe";
import {UppertablePipe} from "../../utils/pipes/uppertable.pipe";

@Component({
  selector: 'app-pipes',
  standalone: true,
  imports: [
    UpperCasePipe,
    LowerCasePipe,
    TitleCasePipe,
    DecimalPipe,
    DatePipe,
    RainbowPipe,
    UppertablePipe
  ],
  templateUrl: './pipes.component.html',
  styleUrl: './pipes.component.css'
})
export class PipesComponent {
  message: string = "Hello World";
  pi: number = Math.PI;
  today: Date = new Date();
  trucs: string[] = [
    'bidule', 'machin', 'chose'
  ]
}
