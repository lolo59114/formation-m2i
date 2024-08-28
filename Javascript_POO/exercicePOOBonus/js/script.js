import Ticket from "./class/ticket.js";

let ticketStorage = localStorage;
const messageInfo = document.getElementById("message-info");
const messageInfoInitClass = [...messageInfo.classList].join(" ");

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

function refreshHistory() {
    const historyDiv = document.getElementById("history-log");
    historyDiv.innerHTML = "";
    const historyUl = document.createElement("ul");
    for(let i = 0; i < ticketStorage.length; i++) {
        const immat = ticketStorage.key(i);
        if(checkImmatriculation(immat)) {
            const ticketLine = document.createElement("li");
            const dateList = document.createElement("ul");
            let dateLine = document.createElement("li");
            let cptDate = 0;
            ticketLine.textContent = `Véhicule ${immat} : `;
            historyUl.appendChild(ticketLine);
            for(let ticketDate of ticketStorage.getItem(immat).split(",")) {
                if(cptDate % 2 == 0) {
                    dateLine = document.createElement("li");
                    dateLine.textContent = `Date arrivé : ${new Date(parseInt(ticketDate)).toISOString()}`;
                } else {
                    dateLine.textContent += ` - Date sortie : ${new Date(parseInt(ticketDate)).toISOString()}`;
                }
                dateList.appendChild(dateLine);
                cptDate++;
            }
            ticketLine.appendChild(dateList);
            historyUl.appendChild(ticketLine);
        }
    }
    historyDiv.appendChild(historyUl);
}
    
function addTicket(ticket, payTicket = false) {
    let parkingDates = ticketStorage.getItem(ticket.immatriculation) ? ticketStorage.getItem(ticket.immatriculation).split(",") : [];
    if(parkingDates.length % 2 != 0 && !payTicket) {
        displayMessage(`Le véhicule ${ticket.immatriculation} possède déjà un ticket depuis ${ticket.arrivalDate}`, "WARNING");
    } else if(parkingDates.length % 2 == 0 && payTicket) {
        displayMessage(`Le véhicule ${ticket.immatriculation} ne possède pas de ticket d'arrivé !`, "ERROR");
    // Aucun problème donc on ajoute le ticket au localstorage
    } else {
        parkingDates.push(ticket.arrivalDate.getTime());
        ticketStorage.setItem(ticket.immatriculation, parkingDates);
        if(!payTicket){
            displayMessage(`Veuillez prendre votre ticket pour le véhicule ${ticket.immatriculation}.`, "INFO");
        } else {
            let price = getPriceFromTicket(ticket);
            displayMessage(`Le prix à payer pour le véhicule ${ticket.immatriculation} est de ${price} €`, "WARNING");
        }
    }
    refreshHistory();
}

function payTicket(immat) {
    if(ticketStorage.getItem(immat) == null) {
        displayMessage(`Le véhicule ${immat} n'existe pas!`, "ERROR");
    } else {
        let lastDate =  new Date(parseInt(ticketStorage.getItem(immat).split(",").pop()));
        let ticket = new Ticket(immat, lastDate); 
        addTicket(ticket, true);
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

refreshHistory();