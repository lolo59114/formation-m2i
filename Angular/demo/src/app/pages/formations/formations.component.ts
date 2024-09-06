import { Component } from '@angular/core';
import {FormationService} from "../../utils/services/formation.service";
import {Formation} from "../../utils/types/formation";

@Component({
  selector: 'app-formations',
  standalone: true,
  imports: [],
  templateUrl: './formations.component.html',
  styleUrl: './formations.component.css'
})
export class FormationsComponent {
  formations?: Formation[] = [];

  constructor(private formationService: FormationService) {
  }

  ngOnInit() {
    this.formations = this.formationService.formations;
  }
}
