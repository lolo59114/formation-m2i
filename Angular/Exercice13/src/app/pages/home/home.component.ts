import { Component } from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {Router, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private router: Router) { }

  form = new FormGroup({
    quantity: new FormControl(5)
  })

  get quantity() {
    return this.form.controls.quantity;
  }

  validate(): void {
    if(this.form.valid) {
      console.log("test navigate")
      this.router.navigate(['/quiz']);
    }
  }
}
