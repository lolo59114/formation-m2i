import { Component } from '@angular/core';
import {FormArray, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {UpperCasePipe} from "@angular/common";
import {Pokemon} from "../../utils/types/pokemon";
import {PokemonCardComponent} from "../../components/pokemon-card/pokemon-card.component";
import {PokedexService} from "../../utils/services/pokedex.service";

@Component({
  selector: 'app-pokemon',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    UpperCasePipe,
    PokemonCardComponent
  ],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent {
  pokemons: Pokemon[] = [];

  constructor(private pokedexService: PokedexService) {
    let stored = localStorage.getItem('pokemons');
    if(stored) {
      this.pokemons = JSON.parse(stored);
    }
  }

  pokemonForm = new FormGroup({
    name: new FormControl("", [Validators.required]),
    description: new FormControl("", [Validators.required]),
    attacks: new FormArray([
        new FormGroup({
          name: new FormControl("", [Validators.required]),
          description: new FormControl("", [Validators.required]),
          damage: new FormControl(0, [Validators.min(0)]),
        })
      ]),
    types: new FormArray([
      new FormControl(""),
    ]),
    area: new FormGroup({
      name: new FormControl("", [Validators.required]),
      region: new FormControl("", [Validators.required]),
    })
  });

  get name() {
    return this.pokemonForm.controls.name;
  }

  get description() {
    return this.pokemonForm.controls.description;
  }

  get attacks() {
    return this.pokemonForm.controls.attacks;
  }

  get types() {
    return this.pokemonForm.controls.types;
  }

  get area() {
    return this.pokemonForm.controls.area;
  }

  savePokemon(): void {
    if(this.pokemonForm.valid) {
      this.pokemons.push(this.pokemonForm.value as Pokemon);
      localStorage.setItem("pokemons", JSON.stringify(this.pokemons));

      this.pokemonForm.reset();
    }
  }

  removePokemonFromPokedex(pokemon: Pokemon) {
    console.log(pokemon);
    this.pokedexService.removePokemon(pokemon);
  }

  addPokemonToPokedex(pokemon: Pokemon) {
    this.pokedexService.addPokemon(pokemon);
  }

  addType(): void {
    this.types.push(new FormControl(""));
  }

  removeType(): void {
    this.types.removeAt(this.types.length - 1);
  }

  addAttack(): void {
    this.attacks.push(new FormGroup({
      name: new FormControl("", [Validators.required]),
      description: new FormControl("", [Validators.required]),
      damage: new FormControl(0, [Validators.min(0)]),
    }));
  }

  removeAttack(): void {
    this.attacks.removeAt(this.attacks.length - 1);
  }

}
