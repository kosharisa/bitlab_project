package server_and_threads.paprica;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {

    private int operationType;
    private ArrayList<Book> books;
    private Book book;

    public PackageData() {
    }

    public PackageData(ArrayList<Book> books) {
        this.books = books;
    }

    public PackageData(int operationType) {
        this.operationType = operationType;
    }

    public PackageData(int operationType, Book book) {
        this.operationType = operationType;
        this.book = book;
    }

    public int getOperationType() {
        return operationType;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType=" + operationType +
                ", books=" + books +
                ", book=" + book +
                '}';
    }
}
