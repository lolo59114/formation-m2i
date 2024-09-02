import { displayAttack, displayDefeat } from "../utils/ihm.js";
import { DiceResultType, roll } from "../utils/dice.js";
export default class Enemy {
    constructor(name, lifePoint, level, ca, attack, damage) {
        this.name = name;
        this.lifePoint = lifePoint;
        this.level = level;
        this.ca = ca;
        this.attack = attack;
        this.damage = damage;
    }
    attackPlayer(player) {
        let diceRoll = roll(20);
        let attack = diceRoll + this.attack;
        let diceResultType;
        let damageDone = 0;
        if (attack >= player.getArmor().getCa() && diceRoll != 1) {
            // on touche
            diceResultType = diceRoll == 20 ? DiceResultType.CRITIC : DiceResultType.SUCCESS;
            damageDone = roll(6) + this.damage;
            damageDone = damageDone < 0 ? 0 : damageDone;
            damageDone = diceRoll == 20 ? damageDone * 2 : damageDone;
            player.setLifePoint(player.getLifePoint() - damageDone);
        }
        else {
            if (diceRoll == 1) {
                this.lifePoint -= 2;
                diceResultType = DiceResultType.FUMBLE;
            }
            else {
                diceResultType = DiceResultType.FAIL;
            }
        }
        displayAttack(attack, damageDone, diceResultType, this.name, false);
        if (player.getLifePoint() <= 0) {
            displayDefeat();
        }
    }
    getCa() {
        return this.ca;
    }
    getAttack() {
        return this.attack;
    }
    getDamage() {
        return this.damage;
    }
    getLifePoint() {
        return this.lifePoint;
    }
    setLifePoint(lp) {
        this.lifePoint = lp;
    }
    getLevel() {
        return this.level;
    }
    getName() {
        return this.name;
    }
}
