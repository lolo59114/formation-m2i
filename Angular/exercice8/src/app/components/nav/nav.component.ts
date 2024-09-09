import {Component, OnDestroy, OnInit} from '@angular/core';
import {RouterLink} from "@angular/router";
import {PokedexService} from "../../utils/services/pokedex.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent implements OnInit, OnDestroy {
  pokedexSize: number = 0;
  subscription?: Subscription;
  constructor(private pokedexService: PokedexService) {
  }

  ngOnInit(): void {
    this.pokedexService.pokedexSize$.subscribe({
      next: value => this.pokedexSize = value
    });
  }

  ngOnDestroy() {
    this.subscription?.unsubscribe();
  }
}
