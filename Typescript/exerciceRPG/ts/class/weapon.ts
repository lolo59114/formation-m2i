export default class Weapon {
    private name: string;
    private attack: number;
    private damage: number; // 1D6 + damage value

    constructor(name: string, attack: number, damage: number) {
        this.name = name;
        this.attack = attack;
        this.damage = damage;
    }

    getAttack(): number {
        return this.attack;
    }

    getDamage(): number {
        return this.damage;
    }

    getName(): string {
        return this.name;
    }
}