let n = Number(prompt("Saisir un nombre: "));
console.log("Les sommes consécutives sont : ");
for(let i = 1; i < (n/2) + 1; i++) {
    let somme = `${n} = ${i}`;
    let value = i;
    for(let j = i+1; j < (n/2) + 1; j++) {
        somme += `+${j}`;
        value += j;
        if(value == n) {
            console.log("\t"+somme);
            break;
        }else if(value > n) {
            break;
        }
    }
}