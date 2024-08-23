const output = document.getElementById("selectOutput");
const textOutput = document.createElement("p");
output.appendChild(textOutput);

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
        nom: document.getElementById("dog-name").value,
        race: document.getElementById("dog-breed").value,
        age: document.getElementById("dog-age").value,
    }
    return chien;
}

function refillSelect(listeChiens) {
    const dogSelect = document.getElementById("dog-select");
    const dogHeaderOption = dogSelect.firstElementChild;
    let options = [];
    options.push(dogHeaderOption);
    for(const chien of listeChiens) {
        const chienOption = document.createElement("option");
        chienOption.value = chien.id;
        chienOption.textContent = chien.nom;
        options.push(chienOption);
    }
    dogSelect.replaceChildren(...options)
    dogSelect.value = "0";
    textOutput.textContent = "";
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
    refillSelect(listeChiens);
});

document.getElementById("dog-select").addEventListener("change", (e) => {
    let text = "";
    if (e.target.value != "0") {
        text = `Vous avez sélectionné le chien avec l'ID : ${e.target.value}`;
    }
    textOutput.textContent = text;
});