import { Component } from '@angular/core';
import {FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-formulaire',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
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

  /*
  Reactive Forms
   */

  book_control: FormControl = new FormControl("", [
    Validators.required,
    Validators.minLength(5),
    Validators.pattern("^[A-Za-z0-9 ']*$"),
  ]);

  saveBook(): void {
    if(this.book_control.valid){
      console.log("livre sauvegardé", this.book_control.value);
      this.book_control.reset();
    }
  }

  /*
  Form Group
   */

  formationForm = new FormGroup({
    title: new FormControl("", [Validators.required]),
    duration: new FormControl(0, [Validators.min(0)]),
    trainer: new FormGroup({
      firstname: new FormControl("Toto", [Validators.required]),
      lastname: new FormControl("Tata", [Validators.required])
    }),
    modules: new FormArray([
      new FormControl(""),
      new FormControl("")
    ])
  });

  get title() {
    return this.formationForm.controls.title;
  }

  get duration() {
    return this.formationForm.controls.duration;
  }

  get firstname() {
    return this.formationForm.controls.trainer.controls.firstname;
  }

  get lastname() {
    return this.formationForm.controls.trainer.controls.lastname;
  }

  get modules() {
    return this.formationForm.controls.modules;
  }

  addModule(): void {
    this.modules.push(new FormControl(""));
  }

  deleteModule(): void {
    this.modules.removeAt(this.modules.length - 1);
  }

  saveFormation(): void {
    if(this.formationForm.valid) {
      console.log(this.formationForm.value);
      this.formationForm.reset();
    }
  }


}
