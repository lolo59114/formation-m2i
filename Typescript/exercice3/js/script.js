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
function calculate_age(dateOfBirth) {
    var diff_ms = Date.now() - dateOfBirth.getTime();
    var age_dt = new Date(diff_ms);
    return Math.abs(age_dt.getUTCFullYear() - 1970);
}
function displayContact(idContact) {
    let contact = contactList.find(c => c.getId() === idContact);
    console.log(contact);
    if (contact) {
        const ageSpan = document.getElementById("text-age");
        const formInputs = displayForm.querySelectorAll("input");
        const formattedBirthday = `${contact.getBirthDay().getFullYear()}-${contact.getBirthDay().getMonth()}-${contact.getBirthDay().getDate()}`;
        formInputs[0].value = contact.getLastname();
        formInputs[1].value = contact.getFirstname();
        formInputs[2].value = formattedBirthday;
        formInputs[3].value = contact.getEmail();
        formInputs[4].value = contact.getPhoneNumber();
        ageSpan.textContent = `${calculate_age(contact.getBirthDay())} yo`;
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
let contact = new Contact("Loic", "VI", new Date("1995-12-17"), "0520202020", "loicVI@Gmailc.com");
let contact2 = new Contact("Loick", "Wa", new Date("1998-11-11"), "0522202020", "loickWA@Gmailc.com");
contactList.push(contact);
contactList.push(contact2);
refreshListContact();
