function listeEtudiants(etudiants) {
    for (let etudiant of etudiants) {
        console.log("Etudiant : " + etudiant.prenom + " " + etudiant.nom);
        const matieres = etudiant.matieres;
        let total = 0;
        for (const matiere in matieres) {
            console.log(`\t${matiere} : ${matieres[matiere]}`);
            total += matieres[matiere];
        }
        let moyenneGenerale = total / Object.keys(matieres).length;
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
