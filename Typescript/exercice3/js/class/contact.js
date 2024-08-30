class Contact {
    constructor(firstname, lastname, birthDay, phoneNumber, email, imgUrl) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.imgUrl = imgUrl;
        this.id = ++Contact.contactCpt;
    }
    getId() {
        return this.id;
    }
    getFirstname() {
        return this.firstname;
    }
    getLastname() {
        return this.lastname;
    }
    getBirthDay() {
        return this.birthDay;
    }
    getPhoneNumber() {
        return this.phoneNumber;
    }
    getEmail() {
        return this.email;
    }
    getImgUrl() {
        return this.imgUrl;
    }
}
Contact.contactCpt = 0;
export default Contact;
