function listeEtudiants(etudiants) {
    for(let i = 0; i < etudiants.length; i++) {
        console.log("Etudiant : " + etudiants[i].prenom + " " + etudiants[i].nom);
        const {matieres} = etudiants[i];
        for(const matiere in matieres) {
            console.log(`\t${matiere} : ${matieres[matiere]}`);
        }
        let moyenneGenerale = Object.values(matieres).reduce((total, note) => total + note) / Object.keys(matieres).length;
        console.log("La moyenne est de : " + moyenneGenerale);
    }
}

let etudiants = [ 
    { 
        prenom: "José", 
        nom: "Garcia", 
        matieres: { 
            francais: 16, 
            anglais: 7, 
            humour: 14 
        }  
    }, 
    { 
        prenom: "Antoine", 
        nom: "De Caunes", 
        matieres: { 
            francais: 15, 
            anglais: 6, 
            humour: 16, 
            informatique: 4, 
            sport: 10 
        } 
    } 
];

listeEtudiants(etudiants);