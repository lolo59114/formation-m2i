import Grade from "./class/grade.js";
import Student from "./class/student.js";
import { toCapitalize, refillSelect } from "./class/util.js";

let students = [];
let subjects = [];
let grades = [];
let tableResult = [];

function filterTable() {
    const tableBody = document.querySelector("table tbody");
    const studentFilter = document.getElementById("student-choice").value;
    const subjectFilter = document.getElementById("lessonfield-choice").value;
    tableResult = [];
    tableBody.innerHTML = "";
    if(studentFilter != 0 && subjectFilter != 0)  {
        tableResult = grades.filter((grade) => grade.student?.id == studentFilter && grade.subject == subjectFilter);
    } else if(studentFilter != 0) {
        tableResult = grades.filter((grade) => grade.student?.id == studentFilter);
    } else if(subjectFilter != 0) {
        tableResult = grades.filter((grade) => grade.subject == subjectFilter);
    }

    tableResult.forEach((result) => {
        const tableTr = document.createElement("tr");
        let line = [toCapitalize(result.student.firstname), result.student.lastname.toUpperCase(), toCapitalize(result.subject), result.grade.toFixed(1)];
        line.forEach((value) => {
            const tableTd = document.createElement("td");
            tableTd.textContent = value;
            tableTr.appendChild(tableTd);
        });
        tableBody.appendChild(tableTr);
    });
    showAverageGrade();
}

function showAverageGrade() {
    const averageGradeText = document.getElementById("average-grade");
    const studentFilter = document.getElementById("student-choice").value;
    const subjectFilter = document.getElementById("lessonfield-choice").value;
    averageGradeText.textContent = "";
    if(tableResult.length > 0) {
        console.log(tableResult);
        const total = Object.values(tableResult).reduce((t, result) => t + result.grade, 0);
        const averageGrade = (total / tableResult.length).toFixed(1);
        if(studentFilter != 0 && subjectFilter != 0)  {
            averageGradeText.textContent = `Moyenne en ${subjectFilter} de ${tableResult[0].student.toString()} : ${averageGrade}`;
        } else if (studentFilter != 0) {
            averageGradeText.textContent = `Moyenne générale de ${tableResult[0].student.toString()} : ${averageGrade}`;
        } else if (subjectFilter != 0) {
            averageGradeText.textContent = `Moyenne générale en ${subjectFilter} : ${averageGrade}`;
        }
    }
}

function addStudent(student) {
    students.push(student);
    refillSelect("student-choice", students, "Toute la classe");
    refillSelect("grade-student", students, "Sélectionnez un élève");
}

// Faire les trois boutons en une ligne
document.getElementsByName("btn-visibility").forEach((element) => {
    element.addEventListener("click", (e) => {
        // on doit faire deux fois 'nextElementSibling' à cause des <hr>
        e.target.textContent === "OFF" ? e.target.textContent = "ON" : e.target.textContent = "OFF";
        e.target.parentElement.nextElementSibling.nextElementSibling.classList.toggle("hidden");
    });
})

// Faire les trois boutons via l'id
// document.getElementById("add-student-visibility").addEventListener("click", () => {
//     document.getElementById("add-student-form").classList.toggle("hidden");
// });

// document.getElementById("add-lessonfield-visibility").addEventListener("click", () => {
//     document.getElementById("add-lessonfield-form").classList.toggle("hidden");
// });

// document.getElementById("add-grade-visibility").addEventListener("click", () => {
//     document.getElementById("add-grade-form").classList.toggle("hidden");
// });

document.getElementById("btnajoutstudent").addEventListener("click", () => {
    let firstname = document.getElementById("student-firstname").value;
    let lastname = document.getElementById("student-lastname").value;
    let student = new Student(firstname, lastname);
    addStudent(student);
});


document.getElementById("btnajoutmatiere").addEventListener("click", () => {
    let subject = document.getElementById("lesson-field").value;
    subjects.push(subject);
    refillSelect("lessonfield-choice", subjects, "Toutes les matières");
    refillSelect("grade-field", subjects, "Sélectionnez une matière");
});

document.getElementById("btnajoutnote").addEventListener("click", () => {
    let studentId = document.getElementById("grade-student").value;
    let gradeValue = Number(document.getElementById("grade").value);
    let subjectId = document.getElementById("grade-field").value;
    let grade = new Grade(students.find((student) => student.id == studentId), gradeValue, subjects.find((subject) => subject == subjectId));
    grades.push(grade);
    filterTable();
});



document.getElementById("student-choice").addEventListener("change", () => {
    filterTable();
});

document.getElementById("lessonfield-choice").addEventListener("change", () => {
    filterTable();
});
