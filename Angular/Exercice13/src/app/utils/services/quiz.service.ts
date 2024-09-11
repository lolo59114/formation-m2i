import { Injectable } from '@angular/core';
import {Question} from "../types/question";

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  questions: Question[] = [
    {
      id: 1,
      question: "De quelle couleur est une poire ?",
      answers: [
        {answer: "Bleue", isCorrect: false},
        {answer: "Rouge", isCorrect: false},
        {answer: "Verte", isCorrect: true},
        {answer: "Violette", isCorrect: false},
      ]
    },
    {
      id: 2,
      question: "De quelle couleur est une banane ?",
      answers: [
        {answer: "Blanche", isCorrect: false},
        {answer: "Jaune", isCorrect: true},
        {answer: "Rouge", isCorrect: false},
        {answer: "Indigo", isCorrect: false},
      ]
    },
  ];

  constructor() { }

  getQuestionsFromApi(quantity: number): void {
    // APPEL API
  }

  getAll(): Question[] {
    return this.questions;
  }

}
