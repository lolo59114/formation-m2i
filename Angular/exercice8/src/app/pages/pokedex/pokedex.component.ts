import { Component } from '@angular/core';
import {PokemonCardComponent} from "../../components/pokemon-card/pokemon-card.component";
import {PokedexService} from "../../utils/services/pokedex.service";
import {Pokemon} from "../../utils/types/pokemon";

@Component({
  selector: 'app-pokedex',
  standalone: true,
    imports: [
        PokemonCardComponent
    ],
  templateUrl: './pokedex.component.html',
  styleUrl: './pokedex.component.css'
})
export class PokedexComponent {

  pokemons: Pokemon[] = [];

  constructor(private pokedexService: PokedexService) {
    this.pokemons = pokedexService.pokemons;
  }

}
