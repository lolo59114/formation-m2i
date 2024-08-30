import Car from "./class/car.js";


let bmw = new Car("Bmw", "Serie 1", 80);
let mercedes = new Car("Mercedes", "GLB", 100);


console.log("on accélère: ");
bmw.accelerate();
console.log(bmw.toString());
console.log("on accélère: ");
bmw.accelerate();
console.log(bmw.toString());
console.log("on accélère: ");
bmw.accelerate();
console.log(bmw.toString());
console.log(mercedes.toString());
console.log("on accélère 2 fois: ");
mercedes.accelerate(2);
console.log(mercedes.toString());
console.log("on tourne 2 fois: ");
mercedes.turn(2);
console.log(mercedes.toString());

console.log(bmw.toString());
console.log(mercedes.toString());