import { Component } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "../../utils/services/auth.service";
import {Router} from "@angular/router";
import {User} from "../../utils/types/user";

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  form = new FormGroup({
    email: new FormControl(""),
    password: new FormControl(""),
    firstname: new FormControl(""),
    lastname: new FormControl(""),
  });

  constructor(private authService: AuthService, private router: Router) {}

  handleSubmit() {
    const user = this.form.value as User;
    this.authService.register(user).subscribe({
      next: (resp) => {
        if(resp) {
          alert("Vous êtes bien enregisté !");
          this.router.navigate(['/login']);
        }
      }
    });
  }
}
