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

function affichageBaseHTML() {
    const main = document.createElement("main");
    const hr = document.createElement("hr");
    const h1 = document.createElement("h1");
    const h2 = document.createElement("h2");
    const divListNotes = document.createElement("div");
    const divResultNotes = document.createElement("div");
    h1.innerText = "Notes";
    h2.innerText = "Meilleur note, pire note, moyenne des notes";
    main.appendChild(h1);
    main.appendChild(hr);
    main.appendChild(h2);
    main.appendChild(hr.cloneNode(true));
    divListNotes.setAttribute("id", "divListNotes");
    main.appendChild(divListNotes);
    main.appendChild(hr.cloneNode(true));
    divResultNotes.setAttribute("id", "divResultNotes");
    main.appendChild(divResultNotes);
    document.querySelector("body").appendChild(main);
}

function affichageListeNotes(tab) {
    const divListNotes = document.querySelector("#divListNotes");
    const divHeader = document.createElement("p");
    const noteUl = document.createElement("ul");
    divHeader.innerHTML = `La série contient <b> ${tab.length} notes </b> :`;
    divListNotes.appendChild(divHeader);
    tab.forEach((note, index) => {
        const noteLi = document.createElement("li");
        noteLi.innerHTML = `En note <b>${index + 1}</b>, vous avez saisi <b> ${note}/20 </b>`;
        noteUl.appendChild(noteLi);
    });
    divListNotes.appendChild(noteUl);
}

function getNoteMax(tab) {
    return Math.max(...tab);
}

function getNoteMin(tab) {
    return Math.min(...tab);
}

function getNoteMoy(tab) {
    let cumul = 0, moyenne;
    // tab.forEach((note) => cumul += note);
    cumul = tab.reduce((total, note) => total + note);
    moyenne = cumul / tab.length
    return moyenne;
}

function affichageResultNotes(tab) {
    const divResultNotes = document.querySelector("#divResultNotes");
    const divHeader = document.createElement("p");
    const noteUl = document.createElement("ul");
    divHeader.innerHTML = `Sur l'ensemble des <b> ${tab.length} notes </b> :`;
    divResultNotes.appendChild(divHeader);
    for(let i = 0; i < 3; i++) {
        const noteLi = document.createElement("li");
        let noteInnerHtml;
        switch(i) {
            case 0:
                noteInnerHtml = `La meilleure note est <b> ${getNoteMax(tab)}/20 </b>`;
                noteLi.style.color = "green";
                break;
            case 1:
                noteInnerHtml = `La pire note est <b> ${getNoteMin(tab)}/20 </b>`;
                noteLi.style.color = "red";
                break;
            case 2:
                noteInnerHtml = `La moyenne des notes est <b> ${getNoteMoy(tab)}/20 </b>`;
        }
        noteLi.innerHTML = noteInnerHtml;
        noteUl.appendChild(noteLi);
    }
    
    divResultNotes.appendChild(noteUl);
}

// DEBUT 

let tab = [];
let choix;
let isOpen = true;

affichageBaseHTML();

while (choix != "1" && choix != "2") {
    choix = prompt("Choisir un mode de saisie:\n1 : Saisie fixe\n2 : Saisie jusqu'à note négative");
}

switch(choix) {
    case "1":
        console.log("Votre choix : 1");
        tab = saisieFixe();    
        break;
    case "2":
        console.log("Votre choix : 2");
        tab = saisieDynamique();
        break;
}
alert("Fin de Saisie !");

affichageListeNotes(tab);
affichageResultNotes(tab);