function displayNumber(tab) {
    tab.forEach((number) => {console.log(`Le nombre ${number} est ${number%2 == 0 ? "pair" : "impair"}.`)})
}
let tab = []
let nbrElements = Number(prompt("Saisissez le nombre d'éléments du tableau : "));
if(nbrElements > 0) {
    for(let i = 0; i < nbrElements; i++){
        tab[i] = Math.round(1 + Math.random() * 49);
    }
}

displayNumber(tab);
