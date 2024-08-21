function saisirNote(choix) {
    let isCorrect = false;
    let note, ask = "Veuillez entrer une note entre 0 et 20 compris:";
    do {
        note = Number(prompt(ask));
        console.log("choix:" + choix);
        switch(choix) {
            case "1":
                isCorrect = !isNaN(note) && note <= 20 && note >= 0;
                break;
            case "2":
                isCorrect = !isNaN(note) && note <= 20 && note >= -1;
                break;
            default:
                isCorrect = !isNaN(note) && note <= 20 && note >= 0;
        }
        if(!isCorrect) {
            ask = "ERREUR, veuillez réessayer :"
        }
    } while(!isCorrect);
    
    return note;
}

function saisieFixe() {
    let tab = [];
    let nbNotes = Number(prompt("Combien de notes ?"));
    if(nbNotes > 0) {
        for(let i = 0; i < nbNotes; i++){
            tab[i] = saisirNote("1");
        }
    }
    return tab; 
}

function saisieDynamique() {
    let tab = [];
    let i = 0, note;
    do{
        note = saisirNote("2");
        if (note == -1) {
            break;
        }
        tab[i] = note
        i++;
    } while (true);
    return tab;
}

function afficheNoteMax(tab) {
    console.log(`La note maximale est de ${Math.max(...tab)} / 20`);
}

function afficheNoteMin(tab) {
    console.log(`La note minimale est de ${Math.min(...tab)} / 20`);
}

function afficheNoteMoy(tab) {
    let cumul = 0, moyenne;
    tab.forEach((note) => cumul += note);
    moyenne = cumul / tab.length
    console.log(`La moyenne est de ${moyenne} / 20`);
}

// DEBUT 

let tab = [];
let choix;
while (choix != "1" && choix != "2") {
    choix = prompt("Choisir un mode de saisie:\n1 : Saisie fixe\n2 : Saisie jusqu'à note négative");
}

switch(choix) {
    case "1":
        alert("Votre choix : 1");
        tab = saisieFixe();    
        break;
    case "2":
        alert("Votre choix : 2");
        tab = saisieDynamique();
        break;
}
alert("Fin de Saisie !");

afficheNoteMax(tab);
afficheNoteMin(tab);
afficheNoteMoy(tab);