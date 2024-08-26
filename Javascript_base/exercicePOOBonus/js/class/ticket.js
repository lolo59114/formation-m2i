export default class Ticket {
    constructor(immatriculation, arrivalDate) {
        this.immatriculation = immatriculation;
        this.arrivalDate = arrivalDate;
    }

    toString() {
        return `${this.immatriculation}`;
    }
}