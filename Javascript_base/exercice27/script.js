import Car from "./class/car.js";

let bmw = new Car("Bmw", "Serie 1", 80);
let mercedes = new Car("Mercedes", "GLB", 100);

bmw.accelerate(3);
mercedes.accelerate(2);
mercedes.turn(2);

console.log(bmw);
console.log(mercedes);