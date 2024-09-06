import { Injectable } from '@angular/core';
import {Pokemon} from "../types/pokemon";

@Injectable({
  providedIn: 'root'
})
export class PokedexService {

  pokemons: Pokemon[] = [];

  constructor() {
    let stored = localStorage.getItem('pokedex');
    if(stored) {
      this.pokemons = JSON.parse(stored);
    }
  }

  addPokemon(pokemon: Pokemon): void {
    if(!this.checkCatched(pokemon)) {
      this.pokemons.push(pokemon);
      localStorage.setItem("pokedex", JSON.stringify(this.pokemons));
    }
  }

  removePokemon(pokemon: Pokemon): void {
    let index: number = this.pokemons.findIndex((p) => p.name === pokemon.name);
    if(index > -1) {
      this.pokemons.splice(index, 1);
      localStorage.setItem("pokedex", JSON.stringify(this.pokemons));
    }
  }

  checkCatched(pokemon: Pokemon): boolean {
    return (this.pokemons.findIndex((p) => p.name === pokemon.name) > -1);
  }
}
