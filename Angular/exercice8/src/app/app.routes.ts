import { Routes } from '@angular/router';
import {SeriesComponent} from "./pages/series/series.component";
import {LibrairieComponent} from "./pages/librairie/librairie.component";
import {PokemonComponent} from "./pages/pokemon/pokemon.component";
import {PokedexComponent} from "./pages/pokedex/pokedex.component";

export const routes: Routes = [
  {path: 'series', component: SeriesComponent},
  {path: 'librairie', component: LibrairieComponent},
  {path: 'pokemon', component: PokemonComponent},
  {path: 'pokedex', component: PokedexComponent},
];