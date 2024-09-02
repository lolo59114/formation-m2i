import Armor from "./class/armor.js";
import Character from "./class/character.js";
import Enemy from "./class/enemy.js";
import Weapon from "./class/weapon.js";
import { displayEncounter } from "./utils/ihm.js";
const characterNameElement = document.getElementById("characterName");
const characterCurrentLPElement = document.getElementById("characterCurrentLP");
const characterMaxLPElement = document.getElementById("characterMaxLP");
const characterLevelElement = document.getElementById("characterLevel");
const characterCurrentXPElement = document.getElementById("currentXP");
const characterMaxXPElement = document.getElementById("maxXP");
const weaponNameElement = document.getElementById("weaponName");
const weaponAttackElement = document.getElementById("weaponAttack");
const weaponDamageElement = document.getElementById("weaponDamage");
const armorNameElement = document.getElementById("armorName");
const armorCAElement = document.getElementById("armorCA");
const enemyNameElement = document.getElementById("enemyName");
const enemyCurrentLPElement = document.getElementById("enemyCurrentLP");
const enemyAttackElement = document.getElementById("enemyAttack");
const enemyDamageElement = document.getElementById("enemyDamage");
const enemyCAElement = document.getElementById("enemyCA");
const enemies = [
    new Enemy("Slime", 15, 1, 10, -2, -2),
    new Enemy("Goomba", 12, 1, 10, -1, -1),
    new Enemy("Gobelin", 20, 2, 12, 0, 1),
    new Enemy("Troll", 100, 3, 14, -1, 5)
];
let armor = new Armor("Gambison", 16);
let weapon = new Weapon("Epée en bois", 5, 1);
let characterName = prompt("Quel est votre nom ?");
let character = new Character(characterName, 100, armor, weapon);
function copyEnemy(enemy) {
    let copy = new Enemy(enemy.getName(), enemy.getLifePoint(), enemy.getLevel(), enemy.getCa(), enemy.getAttack(), enemy.getDamage());
    return copy;
}
function encounter() {
    let enemiesOK = enemies.filter((e) => e.getLevel() <= character.getLevel() + 1);
    let picked = Math.floor(Math.random() * enemiesOK.length);
    let enemyPick = copyEnemy(enemiesOK[picked]);
    displayEncounter(enemyPick);
    return enemyPick;
}
function refreshCharacterDisplay() {
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
function refreshEnemyDisplay() {
    enemyNameElement.textContent = enemy.getName();
    enemyCurrentLPElement.textContent = enemy.getLifePoint().toString();
    enemyAttackElement.textContent = `1D20 ${enemy.getAttack() >= 0 ? "+" : ""} ${enemy.getAttack().toString()}`;
    enemyDamageElement.textContent = `1D6 ${enemy.getDamage() >= 0 ? "+" : ""} ${enemy.getDamage().toString()}`;
    enemyCAElement.textContent = enemy.getCa().toString();
}
refreshCharacterDisplay();
let enemy = encounter();
refreshEnemyDisplay();
document.getElementById("btn-attack").addEventListener("click", () => {
    character.attack(enemy);
    if (enemy.getLifePoint() > 0)
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
