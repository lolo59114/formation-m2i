import Enemy from "../class/enemy.js";
import { DiceResultType } from "./dice.js";

const eventInfoElement = document.getElementById("event-info") as HTMLDivElement;


function resetEventInfo(): void {
    eventInfoElement.textContent = "";
}

function addEventInfo(message: string, isPlayer: boolean = true): void {
    const messageElement = document.createElement("p");
    messageElement.textContent = message; 
    messageElement.style.color = isPlayer ? "lightgreen" : "orange";
    eventInfoElement.appendChild(messageElement);
}

export function displayAttack(attack: number, damageDone: number, diceResult: DiceResultType, name: string, isPlayer: boolean = true): void {
    let message: string = "";
    switch(diceResult) {
        case DiceResultType.CRITIC:
            message = "REUSSITE CRITIQUE !!!";
            message += ` Le jet de ${name} est de ${attack} et inflige ${damageDone} de dégâts.`;
            break;
        case DiceResultType.SUCCESS:
            message = `Le jet de ${name} est de ${attack} et inflige ${damageDone} de dégâts.`;
            message += " L'attaque est un succès !";
           
            break;
        case DiceResultType.FAIL:
            message = `Le jet de ${name} est de ${attack}`;
            message += " C'est raté !";
            break;
        case DiceResultType.FUMBLE:
            message = `ECHEC CRITIQUE !!! ${name} se blesse tout seul...`;
            message += ` ${name} perd 2 points de vies.`;
            break;
    }
    addEventInfo(message, isPlayer);
}

export function displayEscape(): void {
    alert("Vous avez perdu 3 points de vie dans la fuite !");
}

export function displayLevelUp(level: number): void {
    alert("Vous gagnez 1 niveau ! Vous êtes maintenant niveau " + level);
}

export function displayVictory(enemyName: string): void {
    alert(`Vous avez battu ${enemyName} !`);
}

export function displayDefeat(): void {
    alert("GAME OVER !");
}

export function displayEncounter(enemy: Enemy): void {
    resetEventInfo();
    addEventInfo(`Vous avez rencontré un ${enemy.getName()} !`);
}