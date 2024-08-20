console.log("Table des matières :");
for(let chap = 1; chap <= 3; chap++) {
  console.log("\t Chapitre " + chap + ":");
  for(let partie = 1; partie <= 3; partie++) {
    console.log(`\t \t -partie ${chap}.${partie}`);
  }
}