function isPalindrome(phrase) {
    phrase = phrase.replaceAll(" ", "").toLowerCase();
    return phrase == phrase.split("").reverse().join("");
}

let saisie = prompt("Saisissez un mot ou une phrase: ");
alert("Est-ce un palimdrome ? " + isPalindrome(saisie));