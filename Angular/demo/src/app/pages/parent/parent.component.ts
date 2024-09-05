import { Component } from '@angular/core';
import {PokemonCardComponent} from "../../components/pokemon-card/pokemon-card.component";
import {User} from "../../utils/types/user";
import {UserCardComponent} from "../../components/user-card/user-card.component";
import {ButtonComponent} from "../../components/button/button.component";
import {CounterComponent} from "../../components/counter/counter.component";

@Component({
  selector: 'app-parent',
  standalone: true,
  imports: [
    PokemonCardComponent,
    UserCardComponent,
    ButtonComponent,
    CounterComponent
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

  counter = 10;

  buttonClick() {
    console.log("jai cliqué");
  }

  modifyCounter(newCounter: number): void {
    this.counter = newCounter;
  }
}
