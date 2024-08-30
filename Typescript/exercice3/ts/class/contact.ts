export default class Contact {
    private static contactCpt = 0;
    private id: number;

    constructor(private firstname: string, private lastname: string, private birthDay: Date, private phoneNumber: string, private email: string, private imgUrl?: string){
        this.id = ++Contact.contactCpt;
    }

    getId(): number {
        return this.id;
    }

    getFirstname(): string {
        return this.firstname;
    }

    getLastname(): string {
        return this.lastname;
    }

    getBirthDay(): Date {
        return this.birthDay;
    }

    getPhoneNumber(): string {
        return this.phoneNumber;
    }

    getEmail(): string {
        return this.email;
    }

    getImgUrl(): string {
        return this.imgUrl;
    }
}