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

function affichageListeEtudiants(etudiants) {
    document.title = "Liste des étudiants";
    const main = document.querySelector("main");
    const listeEtudiants = document.createElement("ul");
    for(const etudiant of etudiants) {
        const ligneEtudiant = document.createElement("li");
        const listeMatieres = document.createElement("ul");
        const ligneMoyenne = document.createElement("li");
        ligneEtudiant.innerText = `Etudiant : ${etudiant.nom} ${etudiant.prenom}`;
        listeEtudiants.appendChild(ligneEtudiant);
        const {matieres} = etudiant;
        for(const matiere in matieres) {
            const ligneMatiere = document.createElement("li");
            ligneMatiere.textContent = `${matiere} : ${matieres[matiere]}/20`;
            listeMatieres.appendChild(ligneMatiere);
        }
        let moyenneGenerale = Object.values(matieres).reduce((total, note) => total + note) / Object.keys(matieres).length;
        ligneMoyenne.textContent = "La moyenne est de : " + moyenneGenerale.toFixed(1) + "/20";
        listeMatieres.appendChild(ligneMoyenne);
        listeEtudiants.appendChild(listeMatieres);
        
    }
    main.appendChild(listeEtudiants);
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

affichageListeEtudiants(etudiants);
// listeEtudiants(etudiants);