import { Component } from '@angular/core';
import {OrdertablePipe} from "../../utils/ordertable.pipe";
import {NgIf, TitleCasePipe, UpperCasePipe} from "@angular/common";
import {ThumbPipe} from "../../utils/thumb.pipe";
import {FormsModule} from "@angular/forms";

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
    ThumbPipe,
    FormsModule,
    NgIf
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
  book: Book = {
    title: "",
    author: "",
    isRead: false
  }
  isSubmitted: boolean = false;

  toggleRead(index: number) {
    this.books[index].isRead = !this.books[index].isRead;
  }

  get bookHasError(): boolean {
    return this.isSubmitted && (this.book.title == '' || this.book.author == '');
  }

  submitBook(): void {
    this.isSubmitted = true;
    if(!this.bookHasError) {
      let newBook: Book = {...this.book}
      this.books.push(newBook);
      this.isSubmitted = false;
    }
  }
}
