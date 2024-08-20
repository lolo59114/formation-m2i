let max_height;
do {
  max_height = Number(prompt("Donnez la hauteur du triangle :"));
} while(isNaN(max_height) || max_height < 1);

let rows = "";
for(let i = 1; i <= max_height; i++) {
  rows += " ".repeat(max_height - i);
  rows += "*".repeat(2*i - 1);
  rows += "\n";
}
console.log(rows);