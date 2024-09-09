import { Component } from '@angular/core';
import {TrashBag} from "../../../utils/types/trashbag";
import {TrashbagService} from "../../../utils/services/trashbag.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-add',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './add.component.html',
  styleUrl: './add.component.css'
})
export class AddComponent {
  trash: Omit<TrashBag, "id"> = {
    name: '',
    capacity: 0,
    hasLace: false,
  }

  constructor(private trashbagService: TrashbagService) {}

  handleSubmit() {
    this.trashbagService.create(this.trash).subscribe();
  }
}
