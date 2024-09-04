import { Routes } from '@angular/router';
import {SeriesComponent} from "./pages/series/series.component";
import {LibrairieComponent} from "./pages/librairie/librairie.component";

export const routes: Routes = [
  {path: 'series', component: SeriesComponent},
  {path: 'librairie', component: LibrairieComponent},
];
