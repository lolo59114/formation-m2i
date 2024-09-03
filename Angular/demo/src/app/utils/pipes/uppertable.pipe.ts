import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'uppertable',
  standalone: true
})
export class UppertablePipe implements PipeTransform {

  transform(value: string[]): string[] {
    return value.map(value => value.toUpperCase());
  }

}
