import Vehicle from "./vehicle.js";

export default class Motorcicle extends Vehicle {
    display() {
        return `Moto : ${super.display()}`;
    }
}