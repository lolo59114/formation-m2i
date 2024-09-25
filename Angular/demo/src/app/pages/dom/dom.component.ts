import {Component, ElementRef, Renderer2, ViewChild} from '@angular/core';

@Component({
  selector: 'app-dom',
  standalone: true,
  imports: [],
  templateUrl: './dom.component.html',
  styleUrl: './dom.component.css'
})
export class DomComponent {

  @ViewChild('myP') p!: ElementRef;

  constructor(private renderer: Renderer2) {}

  changeColor(color: string) {
    this.renderer.setStyle(this.p.nativeElement, 'color', color);
  }
}
