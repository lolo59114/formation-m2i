import { Routes } from '@angular/router';
import {CounterComponent} from "./pages/counter/counter.component";
import {SeriesComponent} from "./pages/series/series.component";

export const routes: Routes = [
  {path: 'counter', component: CounterComponent},
  {path: 'series', component: SeriesComponent},
];
