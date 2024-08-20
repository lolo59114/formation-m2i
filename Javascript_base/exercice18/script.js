function isPalindrome(phrase) {
    return phrase.trim().toLowerCase() == phrase.trim().toLowerCase().split("").reverse().join("");
}

let saisie = prompt("Saisissez un mot ou une phrase: ");
alert("Est-ce un palimdrome ? " + isPalindrome(saisie));