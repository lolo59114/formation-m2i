let min_age = 30, max_salary = 40000, min_year_experience = 5;
let errorMessage = "";

let age = Number(prompt("Saisir votre age : "));
let salary_expected = Number(prompt("Saisir le salaire voulu : "));
let year_experience = Number(prompt("Saisir vos années d'expériences : "));
if(isNaN(age) || isNaN(salary_expected) || isNaN(year_experience)) {
  errorMessage += "Erreur de saisie repérée";
} else {
    if(age < min_age) {
      errorMessage += "Votre age est de " + age + " ans et l'age requis est de : " + min_age + " ans \n";
    }
    if(salary_expected > max_salary) {
      errorMessage += "Le salaire demandé de " + salary_expected + "€ est supérieur à : " + max_salary + "€ \n";
    }
    if(year_experience < min_year_experience) {
      errorMessage += "Votre nombre d'années d'expérience est de : " + year_experience + " ans et le nombre requis est de " + min_year_experience + " ans"
    }
}

if (errorMessage != ""){
    alert (errorMessage);
} else {
    alert("VOUS ETES PRIS !");
}