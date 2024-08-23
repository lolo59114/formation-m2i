import Vehicle from "./vehicle.js";

export default class Car extends Vehicle {
    constructor(brand, model, kilometer, year, clim) {
        super(brand, model, kilometer, year);
        this.clim = clim;
    }

    display() {
        return `Voiture : ${super.display()} ${this.clim ? " - Climatisé" : ""}`
    }

}