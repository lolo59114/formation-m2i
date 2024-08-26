import { toCapitalize } from "./util.js";

export default class Student {
    static id = 0;
    constructor(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = ++Student.id;
    }

    toString() {
        return `${toCapitalize(this.firstname)} ${this.lastname.toUpperCase()}`;
    }
}