export function toCapitalize(word) {
    return word.charAt(0).toUpperCase() + word.slice(1);
}

export function refillSelect(selectId, tab, selectHeader = null) {
    const select = document.getElementById(selectId);
    let options = [];
    if(selectHeader != null) {
        const option = document.createElement("option");
        option.textContent = selectHeader;
        option.value = 0;
        options.push(option);
    }
    for(const element of tab) {
        const option = document.createElement("option");
        option.value = element.id ? element.id : element.valueOf();
        option.textContent = element.toString();
        options.push(option);
    }
    select.replaceChildren(...options)
}