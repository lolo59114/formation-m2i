import {Component, EventEmitter, Input, Output} from '@angular/core';
import {count} from "rxjs";

@Component({
  selector: 'app-counter[count]',
  standalone: true,
  imports: [],
  templateUrl: './counter.component.html',
  styleUrl: './counter.component.css'
})
export class CounterComponent {

    @Input() count!: number;
    @Output() counterChanged = new EventEmitter<number>();

    increment() {
      this.counterChanged.emit(this.count + 1);
    }

    decrement() {
      this.counterChanged.emit(this.count - 1);
    }
}
