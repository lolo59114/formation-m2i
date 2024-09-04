import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'thumb',
  standalone: true
})
export class ThumbPipe implements PipeTransform {

  transform(value: boolean): string {
    return value ? "👍" : "👎";
  }

}
