class Car {
    constructor(brand, model, speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
        this.id = ++Car.carNumber;
    }
    accelerate(times = 1) {
        this.speed += 10 * times;
    }
    turn(times = 1) {
        this.speed -= 5 * times;
    }
    toString() {
        return `Voiture ${this.id} -> ${this.brand},${this.model},${this.speed} km/h`;
    }
}
Car.carNumber = 0;
export default Car;
