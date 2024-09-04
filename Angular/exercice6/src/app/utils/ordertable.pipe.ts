import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ordertable',
  standalone: true
})
export class OrdertablePipe implements PipeTransform {

  transform(value: string[], arg: string): string[] {
    value.sort(function (a, b) {
      if(arg == 'ASC') {
        return a.localeCompare(b);
      } else {
        return b.localeCompare(a);
      }
    });
    return value;
  }

}
