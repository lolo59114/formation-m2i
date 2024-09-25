import {Component, DEFAULT_CURRENCY_CODE, Inject, LOCALE_ID} from '@angular/core';
import {CurrencyPipe, DatePipe} from "@angular/common";
import {TranslateModule, TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-i18n',
  standalone: true,
  imports: [
    DatePipe,
    CurrencyPipe,
    TranslateModule
  ],
  templateUrl: './i18n.component.html',
  styleUrl: './i18n.component.css'
})
export class I18nComponent {

  today = new Date();

  constructor(
    @Inject(LOCALE_ID) public locale: string,
    @Inject(DEFAULT_CURRENCY_CODE) public code: string,
    private translate: TranslateService
  ) {}

  changeLocale(newLocale: string) {
    this.locale = newLocale;
  }

  changeDevise(devise: string) {
    this.code = devise;
  }

  changeLang(lang: string) {
    this.translate.use(lang)
  }
}
