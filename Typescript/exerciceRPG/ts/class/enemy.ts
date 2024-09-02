import { displayAttack, displayDefeat } from "../utils/ihm.js";
import { DiceResultType, roll } from "../utils/dice.js";
import Character from "./character.js";

export default class Enemy {
    private name: string;
    private lifePoint: number;
    private level: number;
    private ca: number;
    private attack: number;
    private damage: number; // 1D6 + damage value

    constructor(name: string, lifePoint: number, level: number, ca: number, attack: number, damage: number) {
        this.name = name;
        this.lifePoint = lifePoint;
        this.level = level;
        this.ca = ca;
        this.attack = attack;
        this.damage = damage;
    }

    attackPlayer(player: Character): void {
        let diceRoll: number = roll(20);
        let attack: number = diceRoll + this.attack;
        let diceResultType: DiceResultType;
        let damageDone: number = 0;
        if(attack >= player.getArmor().getCa() && diceRoll != 1) {
            // on touche
            diceResultType = diceRoll == 20 ? DiceResultType.CRITIC : DiceResultType.SUCCESS;
            damageDone = roll(6) + this.damage;
            damageDone = damageDone < 0 ? 0 : damageDone;
            damageDone = diceRoll == 20 ? damageDone*2 : damageDone;
            player.setLifePoint(player.getLifePoint() - damageDone);
        } else {
            if(diceRoll == 1) {
                this.lifePoint -= 2;
                diceResultType = DiceResultType.FUMBLE;
            } else {
                diceResultType = DiceResultType.FAIL;
            }
        }
        displayAttack(attack, damageDone, diceResultType, this.name, false);
        if(player.getLifePoint() <= 0) {
            displayDefeat();
        }
    }

    getCa(): number {
        return this.ca;
    }

    getAttack(): number {
        return this.attack;
    }
    
    getDamage(): number {
        return this.damage;
    }

    getLifePoint(): number {
        return this.lifePoint;
    }

    setLifePoint(lp: number): void {
        this.lifePoint = lp;
    }

    getLevel(): number{
        return this.level; 
    }

    getName(): string{
        return this.name;
    }


}