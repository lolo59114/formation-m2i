import Car from "./class/car.js";
import Motorcicle from "./class/motorcicle.js";

let car = new Car("Renault", "Kangoo", 240000, 2003, true);
let motorcicle = new Motorcicle("BMW", "R1150R Rockster", 65000, 2005);

const main = document.querySelector("main");
const carParagraph = document.createElement("p");
carParagraph.textContent = car.display();
const motorcicleParagraph = document.createElement("p");
motorcicleParagraph.textContent = motorcicle.display();
main.appendChild(carParagraph);
main.appendChild(motorcicleParagraph);

