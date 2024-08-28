export default class Car {
    constructor(brand, model, speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    accelerate(times = 1) {
        this.speed += 10*times;
    }

    turn(times = 1) {
        this.speed -= 5*times;
    }
}