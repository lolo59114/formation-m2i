let base_thick = 0.1;
let objective_thick = 400000;
let actual_thick = base_thick;
let foldNumber = 0;
while(actual_thick <= objective_thick) {
  foldNumber++;
  actual_thick *= 2;
}
console.log("Nombre de plis requis : " + foldNumber);
console.log("Notre feuille fait maintenant : " + actual_thick/1000 + " m");

base_thick = 400000;
objective_thick = 0.1;
actual_thick = base_thick;
foldNumber = 0;
while(actual_thick >= objective_thick) {
  foldNumber++;
  actual_thick /= 2;
}
console.log("Nombre de déplis requis : " + foldNumber);
console.log("Notre feuille fait maintenant : " + actual_thick + " mm");