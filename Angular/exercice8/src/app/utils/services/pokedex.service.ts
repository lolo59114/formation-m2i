import { Injectable } from '@angular/core';
import {Pokemon} from "../types/pokemon";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PokedexService {

  pokemons: Pokemon[] = [];
  pokedexSize$ = new BehaviorSubject<number>(0);

  constructor() {
    let stored = localStorage.getItem('pokedex');
    if(stored) {
      this.pokemons = JSON.parse(stored);
      this.pokedexSize$.next(this.pokemons.length);
    }
  }

  addPokemon(pokemon: Pokemon): void {
    if(!this.checkCatched(pokemon)) {
      this.pokemons.push(pokemon);
      localStorage.setItem("pokedex", JSON.stringify(this.pokemons));
      this.pokedexSize$.next(this.pokemons.length);
    }
  }

  removePokemon(pokemon: Pokemon): void {
    let index: number = this.pokemons.findIndex((p) => p.name === pokemon.name);
    if(index > -1) {
      this.pokemons.splice(index, 1);
      localStorage.setItem("pokedex", JSON.stringify(this.pokemons));
      this.pokedexSize$.next(this.pokemons.length);
    }
  }

  checkCatched(pokemon: Pokemon): boolean {
    return (this.pokemons.findIndex((p) => p.name === pokemon.name) > -1);
  }
}
