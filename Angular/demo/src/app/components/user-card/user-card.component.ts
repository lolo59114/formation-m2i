import {Component, Input} from '@angular/core';
import {User} from "../../utils/types/user";

@Component({
  selector: 'app-user-card',
  standalone: true,
  imports: [],
  templateUrl: './user-card.component.html',
  styleUrl: './user-card.component.css'
})
export class UserCardComponent {
  @Input() user?: User;
}
