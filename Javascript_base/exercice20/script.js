let tab = [];
for(let i = 0; i < 10; i++){
    // tab[i] = prompt("Saississez une valeur (" + i + "):");
    tab[i] = Math.round(Math.random() * 100);
}
console.log("Affichage des valeurs saisies");
tab.forEach((value, index) => {
    console.log("\t".repeat(index) + value);
})
