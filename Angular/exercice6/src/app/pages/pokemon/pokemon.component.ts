import { Component } from '@angular/core';
import {FormArray, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-pokemon',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent {
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
      console.log(this.pokemonForm.value);
      this.pokemonForm.reset();
    }
  }

  addType() {
    this.types.push(new FormControl(""));
  }

  removeType() {
    this.types.removeAt(this.types.length - 1);
  }

  addAttack() {
    this.attacks.push(new FormGroup({
      name: new FormControl("", [Validators.required]),
      description: new FormControl("", [Validators.required]),
      damage: new FormControl(0, [Validators.min(0)]),
    }));
  }
}
