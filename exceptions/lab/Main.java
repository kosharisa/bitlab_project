package exceptions.lab;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(null);
        library.addBook(new Book("Animal Farm", "Orwell"));
        library.addBook(new Book("dsa", "dsa"));

        library.printBooks();
    }
}
