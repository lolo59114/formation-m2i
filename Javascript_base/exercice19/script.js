function compterLettreA(chaine) {
    let nombreA = 0;
    for(let i = 0; i < chaine.length; i++) {
        if(chaine.charAt(i).toLowerCase() == "a") {
            nombreA++;
        }
    }
    return nombreA;
}

console.log("abba: " + compterLettreA("abba"));
console.log("mixer: " + compterLettreA("mixer"));