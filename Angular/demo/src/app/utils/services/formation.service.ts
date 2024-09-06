import { Injectable } from '@angular/core';
import {Formation} from "../types/formation";

@Injectable({
  providedIn: 'root'
})
export class FormationService {

  formations: Formation[] = [];

  constructor() { }

  addFormation(formation: Formation) {
    this.formations.push(formation);
  }
}
