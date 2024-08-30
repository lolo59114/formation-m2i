import Contact from "./class/contact.js";
const styleButtonContact = "btn btn-sm btn-outline-light mb-2 w-100";
const displayForm = document.getElementById("form-display");
const contactForm = document.getElementById("form-contact");
const contactListDiv = document.getElementById("contact-list-div");
let contactList = [];
function capitalize(word) {
    if (!word)
        return word;
    return word[0].toUpperCase() + word.substring(1).toLowerCase();
}
function displayContact(idContact) {
    console.log("mon id = " + idContact);
    let contact = contactList.find(c => c.getId() === idContact);
    console.log(contact);
    if (contact) {
        const formData = new FormData(displayForm);
        formData.append("lastname", contact.getLastname());
        formData.append("firstname", contact.getFirstname());
        formData.append("birthday", contact.getBirthDay().toString());
    }
}
function refreshListContact() {
    contactListDiv.textContent = "";
    contactList.forEach((c) => {
        console.log(c);
        const contactButton = document.createElement("button");
        contactButton.textContent = `${capitalize(c.getFirstname())} ${c.getLastname().toUpperCase()}`;
        contactButton.classList.value = styleButtonContact;
        contactButton.addEventListener("click", () => displayContact(c.getId()));
        contactListDiv.appendChild(contactButton);
    });
}
let contact = new Contact("Loic", "VI", new Date(), "0520202020", "loicVI@Gmailc.com");
let contact2 = new Contact("Loick", "Wa", new Date(), "0522202020", "loickWA@Gmailc.com");
contactList.push(contact);
contactList.push(contact2);
refreshListContact();
