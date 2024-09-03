import { Routes } from '@angular/router';
import {PresentationComponent} from "./pages/presentation/presentation.component";
import {BlocksComponent} from "./pages/blocks/blocks.component";
import {PipesComponent} from "./pages/pipes/pipes.component";

export const routes: Routes = [
  {path: 'presentation', component: PresentationComponent},
  {path: 'blocks', component: BlocksComponent},
  {path: 'pipes', component: PipesComponent},
];
