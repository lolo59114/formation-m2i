import { Routes } from '@angular/router';
import {PresentationComponent} from "./pages/presentation/presentation.component";
import {BlocksComponent} from "./pages/blocks/blocks.component";

export const routes: Routes = [
  {path: 'presentation', component: PresentationComponent},
  {path: 'blocks', component: BlocksComponent},
];
