let rayon = Number.parseInt(prompt("Saisir un rayon: "));
let hauteur = Number.parseInt(prompt("Saisir une hauteur: "));
let volume = (Math.PI * (rayon ** 2) * hauteur) / 3;

console.log("Le volume du cône d'un rayon " + rayon + " et d'une hauteur " + hauteur + " est de " + volume);
