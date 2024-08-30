export default class Car {
    private static carNumber: number = 0;
    private id: number;
    private brand: string;
    private model: string;
    private speed: number;

    constructor(brand: string, model: string, speed: number) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
        this.id = ++Car.carNumber;
        
    }

    public accelerate(times = 1): void {
        this.speed += 10*times;
    }

    public turn(times = 1): void {
        this.speed -= 5*times;
    }

    toString(): string {
        return `Voiture ${this.id} -> ${this.brand},${this.model},${this.speed} km/h`;
    }
}