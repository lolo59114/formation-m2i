let max_table;
do {
  max_table = Number(prompt("Jusqu'à quelle table de multiplication voulez-vous afficher ?"));
} while(isNaN(max_table) || max_table < 1);
for(let i = 1; i <= max_table; i++) {
  console.log("Table des " + i + " :");
  for(let j = 1; j <= 10; j++) {
    console.log(`${i} x ${j} = ${i*j}`);
  }
  console.log("---------------");
}
