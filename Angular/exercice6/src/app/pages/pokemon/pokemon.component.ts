import { Component } from '@angular/core';
import {FormArray, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {UpperCasePipe} from "@angular/common";
export type Pokemon = Partial<{
  name: string | null | undefined,
  description: string | null | undefined,
  attacks:
    Partial<{
      name: string | null | undefined,
      description: string | null | undefined,
      damage: number | null | undefined,
    }>[] | undefined,
  types: (string|null)[] | null | undefined,
  area: Partial<{
    name: string | null | undefined,
    region: string | null | undefined,
  }> | undefined,
}>
@Component({
  selector: 'app-pokemon',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    UpperCasePipe
  ],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent {
  pokemons: Pokemon[] = [];

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
      let pokemon: Pokemon = {...this.pokemonForm.value}
      this.pokemons.push(pokemon);
      this.pokemonForm.reset();
    }
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
