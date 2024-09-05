import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Pokemon} from "../../utils/types/pokemon";
import {UpperCasePipe} from "@angular/common";

@Component({
  selector: 'app-pokemon-card[pokemon]',
  standalone: true,
  imports: [
    UpperCasePipe
  ],
  templateUrl: './pokemon-card.component.html',
  styleUrl: './pokemon-card.component.css'
})
export class PokemonCardComponent {
  @Input() pokemon!: Pokemon;
  @Output() pokemonRemove = new EventEmitter<Pokemon>();

  removePokemon() {
    this.pokemonRemove.emit(this.pokemon);
  }
}
