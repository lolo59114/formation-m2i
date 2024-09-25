import {Component, OnInit} from '@angular/core';
import {Question} from "../../utils/types/question";
import {QuizService} from "../../utils/services/quiz.service";
import {QuizCardComponent} from "../../components/quiz-card/quiz-card.component";

@Component({
  selector: 'app-quiz',
  standalone: true,
  imports: [
    QuizCardComponent
  ],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.css'
})
export class QuizComponent implements OnInit{
  questions: Question[] = [];

  constructor(private quizService: QuizService) {}

  ngOnInit() {
    this.questions = this.quizService.getAll();
  }
}
