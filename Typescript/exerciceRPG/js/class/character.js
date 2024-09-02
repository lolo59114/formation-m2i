import { displayAttack, displayEscape, displayLevelUp, displayVictory } from "../utils/ihm.js";
import { DiceResultType, roll } from "../utils/dice.js";
export default class Character {
    constructor(name, maxLifePoint = 100, armor, weapon, xpPoint = 0, level = 1) {
        this.name = name;
        this.maxLifePoint = maxLifePoint;
        this.lifePoint = maxLifePoint;
        this.armor = armor;
        this.weapon = weapon;
        this.xpPoint = xpPoint;
        this.level = level;
    }
    attack(enemy) {
        let diceRoll = roll(20);
        let attack = diceRoll + this.weapon.getAttack();
        let diceResultType;
        let damageDone = 0;
        if (attack >= enemy.getCa() && diceRoll != 1) {
            // on touche
            diceResultType = diceRoll == 20 ? DiceResultType.CRITIC : DiceResultType.SUCCESS;
            damageDone = roll(6) + this.weapon.getDamage();
            damageDone = damageDone <= 0 ? 1 : damageDone;
            damageDone = diceRoll == 20 ? damageDone * 2 : damageDone;
            enemy.setLifePoint(enemy.getLifePoint() - damageDone);
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
        displayAttack(attack, damageDone, diceResultType, this.name);
        if (enemy.getLifePoint() <= 0) {
            displayVictory(enemy.getName());
            this.xpPoint += enemy.getLevel() * 4;
            this.levelUp();
        }
    }
    escape() {
        this.lifePoint -= 3;
        displayEscape();
    }
    levelUp() {
        if (this.xpPoint >= this.level * 10) {
            this.xpPoint -= this.level * 10;
            this.level++;
            this.maxLifePoint += 10;
            this.lifePoint = this.maxLifePoint;
            displayLevelUp(this.level);
        }
    }
    getName() {
        return this.name;
    }
    getLifePoint() {
        return this.lifePoint;
    }
    getMaxLifePoint() {
        return this.maxLifePoint;
    }
    getArmor() {
        return this.armor;
    }
    getWeapon() {
        return this.weapon;
    }
    getXpPoint() {
        return this.xpPoint;
    }
    getLevel() {
        return this.level;
    }
    setName(value) {
        this.name = value;
    }
    setLifePoint(value) {
        this.lifePoint = value;
    }
    setArmor(value) {
        this.armor = value;
    }
    setWeapon(value) {
        this.weapon = value;
    }
    setXpPoint(value) {
        this.xpPoint = value;
    }
    setLevel(value) {
        this.level = value;
    }
}
