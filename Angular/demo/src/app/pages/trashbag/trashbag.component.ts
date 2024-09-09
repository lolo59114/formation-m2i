import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-trashbag',
  standalone: true,
  imports: [
    RouterLink,
    RouterOutlet
  ],
  templateUrl: './trashbag.component.html',
  styleUrl: './trashbag.component.css'
})
export class TrashbagComponent {

}
