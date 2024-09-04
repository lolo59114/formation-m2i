import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-formulaire',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './formulaire.component.html',
  styleUrl: './formulaire.component.css'
})
export class FormulaireComponent {
  message: string = "coucou";
  message2: string = "";
  user = {
    name: "",
    email: "",
    password: "",
  }
  isSubmitted: boolean = false;

  updateMessage(e: Event) {
    const inputMessage = e.target as HTMLInputElement;
    this.message = inputMessage.value;
  }

  get passwordHasError() {
    return this.isSubmitted && this.user.password.length < 6;
  }

  submitUser() {

    this.isSubmitted = true;
    if(!this.passwordHasError) {
      console.log(this.user);
      this.isSubmitted = false;
      console.log("password has error");
    }
  }
}
