export default class Armor {
    private name: string;
    private ca: number;
    constructor(name: string, ca: number) {
        this.name = name;
        this.ca = ca;
    }


    /**
     * Getter name
     * @return {string}
     */
	public getName(): string {
		return this.name;
	}

    /**
     * Getter ca
     * @return {number}
     */
	public getCa(): number {
		return this.ca;
	}

    /**
     * Setter name
     * @param {string} value
     */
	public setName(value: string) {
		this.name = value;
	}

    /**
     * Setter ca
     * @param {number} value
     */
	public setCa(value: number) {
		this.ca = value;
	}

}