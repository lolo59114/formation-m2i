function verificationAdn(chaine) {
    let regex = /^[atcg]*$/;
    if(!regex.test(chaine)) {
        console.log("Erreur de saisie !!!");
        return false;
    } 
    return true;
}

// saisieVerif est une fonction que doit retourner un booléan
function saisieUtilisateur(ask, saisieVerif) {
    let cpt = 0;
    let saisie;
    do {
        cpt++;
        saisie = prompt(ask);
    } while (!saisieVerif(saisie) && cpt < 5);
    return saisie;
}

function proportion(chaine, sequence) {
    let chaineCheck = chaine.replaceAll(sequence, " ").trim(); // chaine sans la séquence
    let pourcentOccur = (chaine.length - chaineCheck.length) * 100 / chaine.length
    return pourcentOccur;
}

let chaine = saisieUtilisateur("Saisir la chaine:", verificationAdn);
let sequence = saisieUtilisateur("Saisir la séquence:", verificationAdn);
let pourcentOccur = proportion(chaine, sequence);
console.log(`Il y a ${pourcentOccur}% de "${sequence}" dans la chaine "${chaine}"`);




