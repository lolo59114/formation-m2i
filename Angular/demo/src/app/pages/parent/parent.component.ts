import { Component } from '@angular/core';
import {PokemonCardComponent} from "../../components/pokemon-card/pokemon-card.component";
import {User} from "../../utils/types/user";
import {UserCardComponent} from "../../components/user-card/user-card.component";

@Component({
  selector: 'app-parent',
  standalone: true,
  imports: [
    PokemonCardComponent,
    UserCardComponent
  ],
  templateUrl: './parent.component.html',
  styleUrl: './parent.component.css'
})
export class ParentComponent {
  pokemons: string[] = ["Dracaufeu", "Ronflex", "Smogo", "Abra"];
  users: User[] = [
    {firstname: "toto", lastname: "tata", email: "toto@tata"},
    {firstname: "titi", lastname: "tutu", email: "titi@tutu"},
  ];
}
