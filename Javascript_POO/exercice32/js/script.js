import Pokemon from "./class/pokemon.js";

const CSS_CARD_STYLE = "col-6 bg-secondary rounded p-3";
const API_URL = "https://pokeapi.co/api/v2/pokemon";
const IMG_SPRITE_DEFAULT = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Pok%C3%A9_Ball_icon.svg/1200px-Pok%C3%A9_Ball_icon.svg.png";

// document element constants
const imgSpriteElement = document.getElementById("pokemon-sprite");
const cardTitle = document.querySelector(".card-header");
const weightElement = document.getElementById("pokemon-weight");
const heightElement = document.getElementById("pokemon-height");
const typesElement = document.getElementById("pokemon-types");
const abilitiesElement = document.getElementById("pokemon-abilities");
const searchInputElement = document.getElementById("pokemon-search-input");

function init() {
    imgSpriteElement.src = IMG_SPRITE_DEFAULT;
    cardTitle.textContent = "Aucun pokémon sélectionné";
    cardTitle.dataset.id = 0;
    weightElement.textContent = "";
    heightElement.textContent = "";
    typesElement.textContent = "";
    abilitiesElement.textContent = "";
    searchInputElement.value = "";
}

function displayPokemon(pokemon = new Pokemon()) {
    init();
    imgSpriteElement.src = pokemon.spriteUrl;
    cardTitle.textContent = `${pokemon.name} #${pokemon.id}`;
    cardTitle.dataset.id = pokemon.id;
    weightElement.textContent = pokemon.weight + " lbs";
    heightElement.textContent = pokemon.height + "\"";
    for(const type of pokemon.types) {
        const typeElement = document.createElement("p");
        typeElement.classList = CSS_CARD_STYLE;
        typeElement.textContent = type.type.name;
        typesElement.appendChild(typeElement);
    }

    for(const ability of pokemon.abilities) {
        const abilityElement = document.createElement("p");
        abilityElement.classList = CSS_CARD_STYLE;
        abilityElement.textContent = ability.ability.name;
        abilitiesElement.appendChild(abilityElement);
    }
    
}

function createPokemonObject(jsonData) {
    let pokemon = new Pokemon();
    pokemon.id = Number(jsonData.id);
    pokemon.name = jsonData.name;
    pokemon.height = jsonData.height;
    pokemon.weight = jsonData.weight;
    pokemon.types = jsonData.types;
    pokemon.abilities = jsonData.abilities;
    pokemon.spriteUrl = jsonData.sprites.front_default;
    return pokemon;
}

async function searchPokemon(searchValue) {
    try {
        console.log(searchValue);
        const response = await fetch(`${API_URL}/${searchValue}`); 
        const data = await response.json(); 
        let pokemon = createPokemonObject(data);
        displayPokemon(pokemon);
    } catch (error) {
        console.error({ error: `Erreur lors de la récupération du pokémon ${searchValue}` });
    }
}

document.getElementById("pokemon-search-button").addEventListener("click", () => {
    searchPokemon(searchInputElement.value);
});
document.getElementById("pokemon-next").addEventListener("click", () => {
    searchPokemon(parseInt(cardTitle.dataset.id) + 1);
});
document.getElementById("pokemon-previous").addEventListener("click", () => {
    searchPokemon(parseInt(cardTitle.dataset.id) - 1)
});

init();