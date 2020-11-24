package exceptions.lab;

public class Library {

    private String name;
    private String city;
    private Book[] books = new Book[2];
    private int index = 0;

    public Library() {
    }

    public Library(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void addBook(Book book) {
        try {
            books[index] = book;
            index++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The library is full");
        }
    }

    public void printBooks() {
        String info;
        for (int i = 0; i < index; i++) {
            try {
                info = books[i].getData();
            } catch (Exception e) {
                info = "The book is empty";
            }
            System.out.println(info);
        }
    }
}
