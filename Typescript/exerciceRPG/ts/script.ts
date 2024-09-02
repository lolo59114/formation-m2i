import Armor from "./class/armor.js";
import Character from "./class/character.js";
import Enemy from "./class/enemy.js";
import Weapon from "./class/weapon.js";
import { displayEncounter } from "./utils/ihm.js";

const characterNameElement = document.getElementById("characterName") as HTMLElement;
const characterCurrentLPElement = document.getElementById("characterCurrentLP") as HTMLSpanElement;
const characterMaxLPElement = document.getElementById("characterMaxLP") as HTMLSpanElement;
const characterLevelElement = document.getElementById("characterLevel") as HTMLSpanElement;
const characterCurrentXPElement = document.getElementById("currentXP") as HTMLSpanElement;
const characterMaxXPElement = document.getElementById("maxXP") as HTMLSpanElement;
const weaponNameElement = document.getElementById("weaponName") as HTMLSpanElement;
const weaponAttackElement = document.getElementById("weaponAttack") as HTMLSpanElement;
const weaponDamageElement = document.getElementById("weaponDamage") as HTMLSpanElement;
const armorNameElement = document.getElementById("armorName") as HTMLSpanElement;
const armorCAElement = document.getElementById("armorCA") as HTMLSpanElement;
const enemyNameElement = document.getElementById("enemyName") as HTMLElement;
const enemyCurrentLPElement = document.getElementById("enemyCurrentLP") as HTMLSpanElement;
const enemyAttackElement = document.getElementById("enemyAttack") as HTMLSpanElement;
const enemyDamageElement = document.getElementById("enemyDamage") as HTMLSpanElement;
const enemyCAElement = document.getElementById("enemyCA") as HTMLSpanElement;


const enemies: Enemy[] = [
    new Enemy("Slime", 15, 1, 10, -2, -2),
    new Enemy("Goomba", 12, 1, 10, -1, -1),
    new Enemy("Gobelin", 20, 2, 12, 0, 1),
    new Enemy("Troll", 100, 3, 14, -1, 5)
];

let armor: Armor = new Armor("Gambison", 16);
let weapon: Weapon = new Weapon("Epée en bois", 5, 1);
let characterName: string = prompt("Quel est votre nom ?");
let character: Character = new Character(characterName, 100, armor, weapon);

function copyEnemy(enemy: Enemy):  Enemy {
    let copy: Enemy = new Enemy(enemy.getName(), enemy.getLifePoint(), enemy.getLevel(), enemy.getCa(), enemy.getAttack(), enemy.getDamage());
    return copy;
}

function encounter(): Enemy {
    let enemiesOK: Enemy[] = enemies.filter((e) => e.getLevel() <= character.getLevel()+1);
    let picked: number = Math.floor(Math.random()*enemiesOK.length);
    let enemyPick: Enemy = copyEnemy(enemiesOK[picked]);
    displayEncounter(enemyPick);
    return enemyPick;
}

function refreshCharacterDisplay(): void {
    characterNameElement.textContent = characterName;
    characterCurrentLPElement.textContent = character.getLifePoint().toString();
    characterMaxLPElement.textContent = character.getMaxLifePoint().toString();
    characterLevelElement.textContent = character.getLevel().toString();
    characterCurrentXPElement.textContent = character.getXpPoint().toString();
    characterMaxXPElement.textContent = (character.getLevel() * 10).toString();
    weaponNameElement.textContent = character.getWeapon().getName();
    weaponAttackElement.textContent = `1D20 ${character.getWeapon().getAttack() >= 0 ? "+" : ""} ${character.getWeapon().getAttack().toString()}`;
    weaponDamageElement.textContent = `1D6 ${character.getWeapon().getDamage() >= 0 ? "+" : ""} ${character.getWeapon().getDamage().toString()}`;
    armorNameElement.textContent = character.getArmor().getName();
    armorCAElement.textContent = character.getArmor().getCa().toString();
}

function refreshEnemyDisplay(): void {
    enemyNameElement.textContent = enemy.getName();
    enemyCurrentLPElement.textContent = enemy.getLifePoint().toString();
    enemyAttackElement.textContent = `1D20 ${enemy.getAttack() >= 0 ? "+" : ""} ${enemy.getAttack().toString()}`;
    enemyDamageElement.textContent = `1D6 ${enemy.getDamage() >= 0 ? "+" : ""} ${enemy.getDamage().toString()}`;
    enemyCAElement.textContent = enemy.getCa().toString();
}

refreshCharacterDisplay();

let enemy: Enemy = encounter();

refreshEnemyDisplay();

document.getElementById("btn-attack").addEventListener("click", () => {
    character.attack(enemy);
    if(enemy.getLifePoint() > 0)
        enemy.attackPlayer(character);
    else 
        enemy = encounter();

    refreshCharacterDisplay();
    refreshEnemyDisplay();
});

document.getElementById("btn-escape").addEventListener("click", () => {
    character.escape();
    refreshCharacterDisplay();
    enemy = encounter();
    refreshEnemyDisplay();
});


