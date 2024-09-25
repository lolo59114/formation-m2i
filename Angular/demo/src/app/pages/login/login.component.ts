import { Component } from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {User} from "../../utils/types/user";
import {AuthService} from "../../utils/services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  form = new FormGroup({
    email: new FormControl(""),
    password: new FormControl(""),
  });

  constructor(private authService: AuthService, private router: Router) {}
  handleSubmit() {
    const cred = this.form.value as Pick<User, "email" | "password">;
    this.authService.login(cred).subscribe({
      next: (resp) => {
        if(resp) {
          alert("Vous êtes connecté");
          this.router.navigate(["/"]);
        }
      }
    })
  }

}
