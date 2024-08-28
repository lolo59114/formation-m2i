import Contact from "./class/contact.js";

let listContacts = [];
const tableBody = document.querySelector("#table-contacts tbody");
    
function addContact(contact) {
    listContacts.push(contact);
    const tableTr = document.createElement("tr");
    for(let property in contact) {
        const tableTd = document.createElement("td");
        tableTd.textContent = contact[property];
        tableTr.appendChild(tableTd);
    }
    tableBody.appendChild(tableTr);
}

document.querySelector("form").addEventListener("submit", (e) => {
    e.preventDefault();
    let myFormData = new FormData(e.target);
    let contact = new Contact(myFormData.get("title"), myFormData.get("firstname"), myFormData.get("lastname"), myFormData.get("birthdate"), myFormData.get("phone-number"), myFormData.get("email"));
    console.log(contact);
    addContact(contact);
    e.target.reset();
});