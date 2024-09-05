import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-button',
  standalone: true,
  imports: [],
  templateUrl: './button.component.html',
  styleUrl: './button.component.css'
})
export class ButtonComponent {
  @Output() clickEvent = new EventEmitter();

  handleClick() {
    this.clickEvent.emit();
  }
}
