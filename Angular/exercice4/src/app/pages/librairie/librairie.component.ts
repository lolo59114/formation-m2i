import { Component } from '@angular/core';
import {OrdertablePipe} from "../../utils/ordertable.pipe";
import {TitleCasePipe, UpperCasePipe} from "@angular/common";
import {ThumbPipe} from "../../utils/thumb.pipe";

interface Book {
  title: string;
  author: string;
  isRead: boolean;
}

@Component({
  selector: 'app-librairie',
  standalone: true,
  imports: [
    OrdertablePipe,
    TitleCasePipe,
    UpperCasePipe,
    ThumbPipe
  ],
  templateUrl: './librairie.component.html',
  styleUrl: './librairie.component.css'
})
export class LibrairieComponent {
  books: Book[] = [
    {title: "Chair de poule", author: "Inconnu", isRead: false},
    {title: "Anneaux de pouvoirs", author: "Tolkien", isRead: false},
    {title: "Kid Paddle", author: "Jsais plus", isRead: false},
    {title: "Dragon ball Z", author: "Toriyama", isRead: false},
  ]

  toggleRead(index: number) {
    this.books[index].isRead = !this.books[index].isRead;
  }
}
