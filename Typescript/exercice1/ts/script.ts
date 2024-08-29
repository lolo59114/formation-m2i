import Library from "./classe/library.js";
import Author from "./interface/author.js";
import Book from "./interface/book.js";

function createBook(title: string, author: Author, pages: number): Book {
    let book: Book = {
        title: title,
        author: author,
        pages: pages,
        isAvailable: true
    };
    return book;
}

function createAuthor(name: string, birthYear: Date, genres: string[]): Author {
    let author: Author = {
        name: name,
        birthYear: birthYear,
        genres: genres
    }
    return author;
}


function toggleAvailability(book: Book): void {
    book.isAvailable = !book.isAvailable;
}

let library: Library = new Library();
let loic: Author = createAuthor("Loic", new Date("1993-10-10"), ["Comédie", "Policier", "Manga"]);
let loick: Author = createAuthor("Loick", new Date("1995-10-10"), ["Fantastique", "Poésie"]);
let book1: Book = createBook("BookTitle", loic, 150);
let book2: Book = createBook("Le petit prince", loic, 250);
let book3: Book = createBook("DBZ Tome 1", loic, 50);
let book4: Book = createBook("DBZ Tome2", loic, 60);
let book5: Book = createBook("JS Pour les nuls", loick, 180);
let book6: Book = createBook("Java Pour les nuls", loick, 200);
library.addBook(book1);
library.addBook(book2);
library.addBook(book3);
library.addBook(book4);
library.addBook(book5);
library.addBook(book6);
console.log(library);
library.removeBook("Le petit prince");
console.log("après suppression du livre petit prince");
console.log(library);
console.log("findBookByTitle: " + JSON.stringify(library.findBookByTitle("DBZ Tome 1")));
console.log("On réserve le livre DBZ Tome 1");
toggleAvailability(library.findBookByTitle("DBZ Tome 1"));
console.log("liste Available: " + JSON.stringify(library.listAvailableBooks()));
console.log("library.getBooksByAuthor Loic : " + JSON.stringify(library.getBooksByAuthor("Loic"))); 
console.log("library.getBooksByAuthor Loick : " + JSON.stringify(library.getBooksByAuthor("Loick")));
console.log(library);