let max_height;
do {
  max_height = Number(prompt("Donnez la hauteur du triangle :"));
} while(isNaN(max_height) || max_height < 1);


let row = "";
for(let i = 0; i < max_height; i++) {
  row = "";
  for(let j = max_height; j > i; j--) {
    row += " ";
  }
  row += "*".repeat(1 + 2*i);

  console.log(row);
}