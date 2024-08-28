export default class Pokemon {
    constructor(id, name, weight, height, types, abilities, spriteUrl) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.types = types;
        this.abilities = abilities;
        this.spriteUrl = spriteUrl;
    }

    toString() {
        return `${this.id} : ${this.name} : ${this.weight} lbs : ${this.height}" : ${this.types} : ${this.abilities}`;
    }
}