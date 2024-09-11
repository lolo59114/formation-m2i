import { Routes } from '@angular/router';
import {PresentationComponent} from "./pages/presentation/presentation.component";
import {BlocksComponent} from "./pages/blocks/blocks.component";
import {PipesComponent} from "./pages/pipes/pipes.component";
import {HomeComponent} from "./pages/home/home.component";
import {NotFoundComponent} from "./pages/not-found/not-found.component";
import {AdminComponent} from "./pages/admin/admin.component";
import {AddComponent} from "./pages/admin/add/add.component";
import {ParentComponent} from "./pages/parent/parent.component";
import {FormationsComponent} from "./pages/formations/formations.component";
import {RxjsComponent} from "./pages/rxjs/rxjs.component";
import {HttpComponent} from "./pages/rxjs/http/http.component";
import {TrashbagComponent} from "./pages/trashbag/trashbag.component";
import {ListComponent} from "./pages/trashbag/list/list.component";
import {AddComponent as TrashAddComponent} from "./pages/trashbag/add/add.component";
import {RegisterComponent} from "./pages/register/register.component";
import {LoginComponent} from "./pages/login/login.component";
import {isLoggedGuard} from "./utils/guards/is-logged.guard";
import {I18nComponent} from "./pages/i18n/i18n.component";
import {DomComponent} from "./pages/dom/dom.component";

export const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'presentation', component: PresentationComponent},
  {path: 'blocks', component: BlocksComponent},
  {path: 'pipes', component: PipesComponent},
  {path: 'formations', component: FormationsComponent},
  {path: 'formulaire', loadComponent: () => import('./pages/formulaire/formulaire.component').then(m => m.FormulaireComponent)},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdminComponent, canActivate: [isLoggedGuard], children: [
    {path: 'add', component: AddComponent},
    ]},
  {path: 'rxjs', component: RxjsComponent},
  {path: 'http', component: HttpComponent},
  {path: 'i18n', component: I18nComponent},
  {path: 'dom', component: DomComponent},
  {path: 'trash', component: TrashbagComponent, children: [
      {path: '', component: ListComponent},
      {path: 'add', component: TrashAddComponent},
    ]},
  {path: 'parent', component: ParentComponent},
  {path: 'accueil', redirectTo: ''},
  {path: '**', component: NotFoundComponent},
];
