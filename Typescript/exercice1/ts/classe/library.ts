import Book from "../interface/book";

export default class Library {
    private books :Book[];

    constructor(books: Book[] = []) {
        this.books = books;
    }

    public addBook(book: Book): void {
        this.books.push(book);
    }

    public removeBook(title: string): void {
        let index: number = this.books.findIndex((book) => book.title == title);
        this.books.splice(index, 1);
    }

    public findBookByTitle(title: string): Book {
        return this.books.find((book) => book.title == title);
    }

    public listAvailableBooks(): Book[] {
        return this.books.filter((book) => book.isAvailable);
    }

    public getBooksByAuthor(authorName: string): Book[] {
        return this.books.filter((book) => book.author.name == authorName);
    }

}