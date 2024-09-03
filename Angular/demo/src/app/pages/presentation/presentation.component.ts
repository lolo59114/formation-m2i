import { Component } from '@angular/core';
import {NgClass, NgOptimizedImage} from "@angular/common";

@Component({
  selector: 'app-presentation',
  standalone: true,
  imports: [
    NgOptimizedImage,
    NgClass
  ],
  templateUrl: './presentation.component.html',
  styleUrl: './presentation.component.css'
})
export class PresentationComponent {
  name: string = "Siri";
  isLoggedIn: boolean = false;
  galaxy: string = "https://media.istockphoto.com/id/1443562748/fr/photo/mignon-chat-gingembre.jpg?s=612x612&w=0&k=20&c=ygNVVnqLk9V8BWu4VQ0D21u7-daIyHUoyKlCcx3K1E8=";
  color: string = "red";
  size: number = 30;
  myStyle: Object = {
    backgroundColor: "red",
    color: "white",
  }

  toggleLogged(): void {
    this.isLoggedIn = !this.isLoggedIn;
  }
}
