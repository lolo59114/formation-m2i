const TEMP_STATE = Object.freeze({"SOLID" : "solide", "LIQUID" : "liquide", "GAZ" : "gazeuse"});
let temp_celsius = Number(prompt("Veuillez saisir une température en °C"));
let response;

if(temp_celsius < 0) {
    response = TEMP_STATE.SOLID;
} else if(temp_celsius <= 100) {
    response = TEMP_STATE.LIQUID;
} else if(temp_celsius > 100){
    response = TEMP_STATE.GAZ;
} else {
    response = "température saisie incorrecte"
}

alert("L'eau est à l'état : " + response);