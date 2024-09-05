import { Component } from '@angular/core';

let listes: string[] = [
  "test1",
  "test2",
  "test3",
  "test4",
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
