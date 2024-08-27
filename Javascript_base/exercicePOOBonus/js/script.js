import Ticket from "./class/ticket.js";

let listTickets = localStorage;
const messageInfo = document.getElementById("message-info");
const messageInfoInitClass = [...messageInfo.classList].join(" ");

console.log(listTickets);
function checkImmatriculation(immat) {
    return immat.length == 10;
}

function getPriceFromTicket(ticket) {
    const now = new Date();
    if(now - ticket.arrivalDate < 15 * 60 * 1000) {
        return 0.8;
    } else if(now - ticket.arrivalDate < 30 * 60 * 1000) {
        return 1.30;
    } else if(now - ticket.arrivalDate < 45 * 60 * 1000) {
        return 1.7;
    } else {
        return 6;
    }
}

function displayMessage(message, type="INFO", timer=5000) {
    clearTimeout(window.timeout);
    messageInfo.textContent = message;
    // messageInfo.classList = "text-center p-3 mb-3";
    messageInfo.classList = messageInfoInitClass;
    switch(type) {
        case "ERROR":
            messageInfo.classList.add("bg-danger");
            break;
        case "INFO":
            messageInfo.classList.add("bg-info");
            break;
        case "WARNING":
            messageInfo.classList.add("bg-warning");
            break;
    }
    window.timeout = setTimeout(() => messageInfo.classList.add("hidden"), timer);
}
    
function addTicket(ticket) {
    if(listTickets.getItem(ticket.immatriculation)) {
        displayMessage(`Le véhicule ${ticket.immatriculation} possède déjà un ticket depuis ${ticket.arrivalDate}`, "WARNING");
    } else {
        listTickets.setItem(ticket.immatriculation, ticket.arrivalDate.getTime());
        displayMessage(`Veuillez prendre votre ticket pour le véhicule ${ticket.immatriculation}.`, "INFO");
    }
}

function removeTicket(ticket) {
    listTickets.removeItem(ticket.immatriculation);
}

function payTicket(immat) {
    if(listTickets.getItem(immat) == null) {
        displayMessage(`Le véhicule ${immat} n'existe pas!`, "ERROR");
    } else {
        let ticket = new Ticket(immat, listTickets.getItem(immat));
        let price = getPriceFromTicket(ticket);
        displayMessage(`Le prix à payer pour le véhicule ${immat} est de ${price} €`, "WARNING");
        removeTicket(ticket);
    }
}

document.getElementById("btn-get-ticket").addEventListener("click", () => {
    let immat = document.getElementById("immatriculation").value;
    if(checkImmatriculation(immat)) {
        let ticket = new Ticket(immat, new Date());
        addTicket(ticket);
    } else {
        displayMessage("Format de l'immatriculation incorrect ! ", "ERROR");
    }
});

document.getElementById("btn-pay").addEventListener("click", () => {
    let immat = document.getElementById("immatriculation").value;
    if(checkImmatriculation(immat)) {
        payTicket(immat);
    } else {
        displayMessage("Format de l'immatriculation incorrect ! ", "ERROR");
    }
});