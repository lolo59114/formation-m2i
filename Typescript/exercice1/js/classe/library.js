export default class Library {
    constructor(books = []) {
        this.books = books;
    }
    addBook(book) {
        this.books.push(book);
    }
    removeBook(title) {
        let index = this.books.findIndex((book) => book.title == title);
        this.books.splice(index, 1);
    }
    findBookByTitle(title) {
        return this.books.find((book) => book.title == title);
    }
    listAvailableBooks() {
        return this.books.filter((book) => book.isAvailable);
    }
    getBooksByAuthor(authorName) {
        return this.books.filter((book) => book.author.name == authorName);
    }
}
