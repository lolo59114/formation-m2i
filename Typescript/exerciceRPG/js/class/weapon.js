export default class Weapon {
    constructor(name, attack, damage) {
        this.name = name;
        this.attack = attack;
        this.damage = damage;
    }
    getAttack() {
        return this.attack;
    }
    getDamage() {
        return this.damage;
    }
    getName() {
        return this.name;
    }
}
