export default class Grade {
    static id = 0;
    constructor(student, grade, subject) {
        this.student = student;
        this.grade = grade;
        this.subject = subject;
        this.id = ++Grade.id;
    }
}