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
    console.log("mon id = " + idContact);
    let contact = contactList.find(c => c.getId() === idContact);
    console.log(contact);
    if (contact) {
        const formData = new FormData(displayForm);
        const ageSpan = document.getElementById("text-age");
        const formattedBirthday = `${contact.getBirthDay().getFullYear()}-${contact.getBirthDay().getMonth()}-${contact.getBirthDay().getDate()}`;
        formData.set("lastname", contact.getLastname());
        formData.set("firstname", contact.getFirstname());
        formData.set("birthday", formattedBirthday);
        formData.set("email", contact.getEmail());
        formData.set("phoneNumber", contact.getPhoneNumber());
        console.log(formattedBirthday);
        formData.forEach((value, key) => {
            const formInput = document.getElementsByName(key)[0];
            formInput.value = value.toString();
        });
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
