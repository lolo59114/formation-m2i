import { Component } from '@angular/core';

let listes: string[] = [
  "test",
  "test",
  "test",
  "test",
];

@Component({
  selector: 'app-blocks',
  standalone: true,
  imports: [],
  templateUrl: './blocks.component.html',
  styleUrl: './blocks.component.css'
})
export class BlocksComponent {
  listes: string[] = listes;
  remove(index: number) {
    listes.splice(index, 1);
  }
}
