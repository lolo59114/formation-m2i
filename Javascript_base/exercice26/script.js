function addChien({nom, race, age}, list) {
    let newId = 1;
    if (list.length > 0) {
        newId = Math.max.apply(null,list.map(function (obj) { return obj.id; })) +1
    }
    let chien = {
        id: newId,
        nom: nom,
        race: race,
        age: age
    }
    list.push(chien);
}

function formCreateChien() {
    let chien = {
        nom: document.getElementById("dog-name"),
        race: document.getElementById("dog-breed"),
        age: document.getElementById("dog-age"),
    }
    return chien;
}

function refillSelect(listeChiens) {
    const dogSelect = document.getElementById("dog-select");
    const newDogSelect = dogSelect.cloneNode();
    const dogHeaderOption = dogSelect.firstElementChild;
    newDogSelect.appendChild(dogHeaderOption);
    for(const chien of listeChiens) {
        const chienOption = document.createElement("option");
        chienOption.value = chien.id;
        chienOption.textContent = chien.nom;
        newDogSelect.appendChild(chienOption);
    }
    dogSelect.replaceWith(newDogSelect);
}

let listeChiens = [];
let chien = {
    nom: "Medor",
    race: "Labrador",
    age: 10
}
let chien2 = {
    nom: "Rex",
    race: "Bulldog",
    age: 15
}
addChien(chien, listeChiens);
addChien(chien2, listeChiens);
refillSelect(listeChiens);

document.getElementById("btn-submit").addEventListener("click", () => {
    let newChien = formCreateChien();
    addChien(newChien, listeChiens);
});