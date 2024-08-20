const ask = (question, yes, no) => {
    if (confirm(question)) // affiche une boite de dialogue avec la possibilité d'accepter ou refuser
        yes();
    else 
        no();
}

const yes = () => alert("You agreed.");
const no = () => alert("You canceled the execution.");

ask("Do you agree?", yes, no);

// oui j'ai tout remplacé même la fonction de base