let popIni = Number(prompt("Pop initiale: "));
let taux = Number(prompt("Taux accroissement: ")) / 100;
let popFinal = Number(prompt("Objectif de pop: "));
let popCalc, nbAnnees = 0, annee = 2024;

do {
    nbAnnees++;
    popCalc = popIni * Math.pow(1 + taux, nbAnnees);
    console.log("Nombre d'années : " + nbAnnees + " ; Pop initial = " + Math.round(popIni) + " ; Nouvelle pop = " + Math.round(popCalc));
} while (popFinal > popCalc);

annee += nbAnnees;
console.log("Le nombre d'années nécessaires pour atteindre " + popFinal + "  est de " + nbAnnees + " ans");
console.log("La ville aura atteint plus de " + popFinal + " habitants en " + annee);