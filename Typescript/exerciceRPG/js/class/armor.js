export default class Armor {
    constructor(name, ca) {
        this.name = name;
        this.ca = ca;
    }
    /**
     * Getter name
     * @return {string}
     */
    getName() {
        return this.name;
    }
    /**
     * Getter ca
     * @return {number}
     */
    getCa() {
        return this.ca;
    }
    /**
     * Setter name
     * @param {string} value
     */
    setName(value) {
        this.name = value;
    }
    /**
     * Setter ca
     * @param {number} value
     */
    setCa(value) {
        this.ca = value;
    }
}
