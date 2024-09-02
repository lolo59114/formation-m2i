import { displayAttack, displayEscape, displayLevelUp, displayVictory } from "../utils/ihm.js";
import { DiceResultType, roll } from "../utils/dice.js";
import Armor from "./armor.js";
import Enemy from "./enemy.js";
import Weapon from "./weapon.js";

export default class Character {
    private name: string;
    private lifePoint: number;
    private maxLifePoint: number;
    private armor: Armor;
    private weapon: Weapon;
    private xpPoint: number;
    private level: number;
    constructor(name: string, maxLifePoint:number = 100, armor: Armor, weapon: Weapon, xpPoint: number = 0, level: number = 1) {
        this.name = name;
        this.maxLifePoint = maxLifePoint;
        this.lifePoint = maxLifePoint;
        this.armor = armor;
        this.weapon = weapon;
        this.xpPoint = xpPoint;
        this.level = level;
    }

    attack(enemy: Enemy): void {
        let diceRoll: number = roll(20);
        let attack: number = diceRoll + this.weapon.getAttack();
        let diceResultType: DiceResultType;
        let damageDone: number = 0;
        if(attack >= enemy.getCa() && diceRoll != 1) {
            // on touche
            diceResultType = diceRoll == 20 ? DiceResultType.CRITIC : DiceResultType.SUCCESS;
            damageDone = roll(6) + this.weapon.getDamage();
            damageDone = damageDone <= 0 ? 1 : damageDone;
            damageDone = diceRoll == 20 ? damageDone*2 : damageDone;
            enemy.setLifePoint(enemy.getLifePoint() - damageDone);
        } else {
            if(diceRoll == 1) {
                this.lifePoint -= 2;
                diceResultType = DiceResultType.FUMBLE;
            } else {
                diceResultType = DiceResultType.FAIL;
            }
            
        }
        displayAttack(attack, damageDone, diceResultType, this.name);
        if(enemy.getLifePoint() <= 0) {
            displayVictory(enemy.getName());  
            this.xpPoint += enemy.getLevel()*4;
            this.levelUp();
        }
    }

    escape(): void {
        this.lifePoint -= 3;
        displayEscape();
    }

    levelUp(): void {
        if(this.xpPoint >= this.level*10) {
            this.xpPoint -= this.level*10;
            this.level++;
            this.maxLifePoint += 10;
            this.lifePoint = this.maxLifePoint; 
            displayLevelUp(this.level);
        }
    }

	public getName(): string {
		return this.name;
	}

	public getLifePoint(): number {
		return this.lifePoint;
	}

    public getMaxLifePoint(): number {
		return this.maxLifePoint;
	}

	public getArmor(): Armor {
		return this.armor;
	}

	public getWeapon(): Weapon {
		return this.weapon;
	}

	public getXpPoint(): number {
		return this.xpPoint;
	}

	public getLevel(): number {
		return this.level;
	}

	public setName(value: string) {
		this.name = value;
	}

	public setLifePoint(value: number) {
		this.lifePoint = value;
	}

	public setArmor(value: Armor) {
		this.armor = value;
	}

	public setWeapon(value: Weapon) {
		this.weapon = value;
	}

	public setXpPoint(value: number) {
		this.xpPoint = value;
	}

	public setLevel(value: number) {
		this.level = value;
	}


}