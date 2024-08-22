function promptForNumberInput(promptMessage, min, max = Infinity, promptMessageError = "ERREUR, Veuillez resaisir !\n" + promptMessage) {
    let input = Number(prompt(promptMessage));
    while(!validateInputNumber(input, min, max)) {
        input = Number(prompt(promptMessageError));
    }
    return input;
}

function validateInputNumber(input, min, max) {
    if(isNaN(input) || input < min || input > max) {
        return false;
    }
    return true;
}

function saisieContact() {
    let tab = [];
    let nbContact = promptForNumberInput("Nombre de contact à saisir :", 1);
    for(let i = 0; i < nbContact; i++){
        tab[i] = prompt("Veuillez saisir le contact n°" + i+1 + ":");
    }
    return tab; 
}

function displayMenu(contactList) {
    let choix;
    while(true) {
        choix = promptForNumberInput(`
            Faites un choix:
            1. Resaissir les contacts
            2. Afficher les contacts
            3. Trier les contacts
            4. Mélanger les contacts
            5. Supprimer un contact
            6. Rechercher un contact
            0. Quitter l'application
            `, 0, 6);
        switch(choix) {
            case 1:
                contactList = saisieContact();
                break;
            case 2:
                break;
            
            default:
                return;
        }
    }
    
}

// DEBUT 
let contactList = [];
contactList = saisieContact();
displayMenu(contactList);
