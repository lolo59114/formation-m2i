import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Question} from "../../utils/types/question";

@Component({
  selector: 'app-quiz-card[question]',
  standalone: true,
  imports: [],
  templateUrl: './quiz-card.component.html',
  styleUrl: './quiz-card.component.css'
})
export class QuizCardComponent {
  @Input() question!: Question;
  @Output() answerSelect = new EventEmitter<boolean>();

  sendAnswer(event: MouseEvent): void {
    const btnElement = event.target as HTMLButtonElement;
    let index: number = parseInt(btnElement.value);
    if(this.question.answers[index].isCorrect) {
      // Correct answer
      this.answerSelect.emit(true);
    } else {
      // Wrong answer
      this.answerSelect.emit(false);

    }
  }
}
