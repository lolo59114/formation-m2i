let minAge = 30, maxSalary = 40000, minYearExp = 5;
let errorMessage = "";

let age = Number(prompt("Saisir votre age : "));
let salaryExpected = Number(prompt("Saisir le salaire voulu : "));
let experience = Number(prompt("Saisir vos années d'expériences : "));
if(isNaN(age) || isNaN(salaryExpected) || isNaN(experience)) {
  errorMessage += "Erreur de saisie repérée";
} else {
    if(age < minAge) {
      errorMessage += "Votre age est de " + age + " ans et l'age requis est de : " + minAge + " ans \n";
    }
    if(salaryExpected > maxSalary) {
      errorMessage += "Le salaire demandé de " + salaryExpected + "€ est supérieur à : " + maxSalary + "€ \n";
    }
    if(experience < minYearExp) {
      errorMessage += "Votre nombre d'années d'expérience est de : " + experience + " ans et le nombre requis est de " + minYearExp + " ans"
    }
}

if(errorMessage != "") {
    alert(errorMessage);
} else {
    alert("VOUS ETES PRIS !");
}