import {ApplicationConfig, importProvidersFrom, inject, LOCALE_ID, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {HttpClient, provideHttpClient, withInterceptors} from "@angular/common/http";
import {bearerInterceptor} from "./utils/interceptors/bearer.interceptor";
import {TranslateLoader, TranslateModule} from "@ngx-translate/core";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(withInterceptors([bearerInterceptor])),
    {provide: LOCALE_ID, useValue: "fr-FR"},
    importProvidersFrom(
      TranslateModule.forRoot({
        loader: {
          provide: TranslateLoader,
          useFactory: (http: HttpClient) => new TranslateHttpLoader(http, "./assets/i18n/", ".json"),
          deps: [HttpClient]
        }
      })
    )
  ]
};
